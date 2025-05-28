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

    public PedidosDTO salvar(PedidosDTO dto) {
        Pedidos pedido = pedidoMapper.toEntity(dto);
        Pedidos salvo = pedidosClientsRepository.save(pedido);
        return pedidoMapper.toDTO(salvo);
    }

    public List<PedidosDTO> listarTodos() {
        return pedidosClientsRepository.findAll().stream()
                .map(pedidoMapper::toDTO)
                .collect(Collectors.toList());
    }

    /*public Optional<PedidosDTO> buscarPorId(Long id) {
        return pedidosClientsRepository.findById(id).map(pedidoMapper::toDTO);
    }*/

    public PedidosDTO buscarPorId(Long id) {
        Pedidos pedido = pedidosClientsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));

        // Força a carga dos itens (se estiver como fetch LAZY)
        pedido.getItens().size();

        return pedidoMapper.toDTO(pedido);
    }

    @Transactional
    public Optional<Optional<PedidosDTO>> atualizar(Long id, PedidosDTO dto) {
        return pedidosClientsRepository.findById(id).map(pedidoExistente -> {

            // Limpa os itens antigos, se for uma atualização total dos itens
            pedidoExistente.getItens().clear();

            // Atualiza os dados do Pedido (exceto itens)
            pedidoMapper.updateEntityFromDTO(dto, pedidoExistente);

            // Mapeia os itens do DTO para entidade PedidoItem
            List<PedidoItem> novosItens = dto.getItens().stream().map(itemDto -> {
                PedidoItem item = pedidoMapper.toItemEntity(itemDto);
                item.setPedido(pedidoExistente); // Associa o pedido no item
                return item;
            }).toList();

            // Adiciona os itens atualizados
            pedidoExistente.getItens().addAll(novosItens);

            // Salva
            Pedidos salvo = pedidosClientsRepository.save(pedidoExistente);
            return Optional.of(pedidoMapper.toDTO(salvo));
        });
    }



    /*@Transactional
    public Optional<PedidosDTO> atualizar(Long id, PedidosDTO dto) {
        System.out.println("DTO recebido para atualizar: " + dto);
        return pedidosClientsRepository.findById(id).map(pedidoExistente -> {
            pedidoMapper.updateEntityFromDTO(dto, pedidoExistente); // usa @MappingTarget
            Pedidos salvo = pedidosClientsRepository.save(pedidoExistente);
            return pedidoMapper.toDTO(salvo);
        });
    }*/


    /*public Optional<PedidosDTO> atualizar(Long id, PedidosDTO dto) {
        return pedidosClientsRepository.findById(id).map(pedidoExistente -> {
            Pedidos atualizado = pedidoMapper.toEntity(dto);
            atualizado.setId(pedidoExistente.getId()); // Garante que é uma atualização
            Pedidos salvo = pedidosClientsRepository.save(atualizado);
            return pedidoMapper.toDTO(salvo);
        });
    }*/

    public void deletar(Long id) {
        pedidosClientsRepository.deleteById(id);
    }

}
