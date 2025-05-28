package com.marina.springlavanderia.service;

import com.marina.springlavanderia.DTO.PedidosDTO;
import com.marina.springlavanderia.mapper.PedidoMapper;
import com.marina.springlavanderia.model.PedidoItem;
import com.marina.springlavanderia.model.Pedidos;
import com.marina.springlavanderia.repository.PedidosClientsRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidosService {

    private final PedidosClientsRepository pedidosClientsRepository;
    private final PedidoMapper pedidoMapper;

    public PedidosService(PedidosClientsRepository pedidosClientsRepository, PedidoMapper pedidoMapper) {
        this.pedidosClientsRepository = pedidosClientsRepository;
        this.pedidoMapper = pedidoMapper;
    }

    public Optional<PedidosDTO> buscarPorId(Long id) {
        return pedidosClientsRepository.findById(id)
                .map(pedidoMapper::toDTO);
    }

    @Transactional
    public PedidosDTO salvar(PedidosDTO dto) {
        Pedidos pedido = pedidoMapper.toEntity(dto);
        associarPedidoNosItens(pedido);
        Pedidos salvo = pedidosClientsRepository.save(pedido);
        return pedidoMapper.toDTO(salvo);
    }

    @Transactional
    public Optional<PedidosDTO> atualizar(Long id, PedidosDTO dto) {
        return pedidosClientsRepository.findById(id).map(pedidoExistente -> {
            pedidoExistente.getItens().clear();

            pedidoMapper.updateEntityFromDTO(dto, pedidoExistente);

            List<PedidoItem> novosItens = dto.getItens().stream().map(itemDto -> {
                PedidoItem item = pedidoMapper.toItemEntity(itemDto);
                item.setPedido(pedidoExistente);
                return item;
            }).toList();

            pedidoExistente.getItens().addAll(novosItens);

            Pedidos salvo = pedidosClientsRepository.save(pedidoExistente);
            return pedidoMapper.toDTO(salvo);
        });
    }

    public List<PedidosDTO> listarTodos() {
        return pedidosClientsRepository.findAll().stream()
                .map(pedidoMapper::toDTO)
                .toList();
    }

    private void associarPedidoNosItens(Pedidos pedido) {
        pedido.getItens().forEach(item -> item.setPedido(pedido));
    }

    @Transactional
    public boolean deletar(Long id) {
        return pedidosClientsRepository.findById(id).map(pedido -> {
            pedidosClientsRepository.delete(pedido);
            return true;
        }).orElse(false);
    }


}
