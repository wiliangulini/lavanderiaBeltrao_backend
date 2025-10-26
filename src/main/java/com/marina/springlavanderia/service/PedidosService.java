package com.marina.springlavanderia.service;

import com.marina.springlavanderia.DTO.PedidoItemDTO;
import com.marina.springlavanderia.DTO.PedidosDTO;
import com.marina.springlavanderia.mapper.PedidoMapper;
import com.marina.springlavanderia.model.PedidoItem;
import com.marina.springlavanderia.model.Pedidos;
import com.marina.springlavanderia.repository.PedidosClientsRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;
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
        recalcularValorFinal(pedido);
        Pedidos salvo = pedidosClientsRepository.save(pedido);
        return pedidoMapper.toDTO(salvo);
    }

    @Transactional
    public Optional<PedidosDTO> atualizar(Long id, PedidosDTO dto) {
        return pedidosClientsRepository.findById(id).map(pedidoExistente -> {
            // Atualizar campos principais do pedido
            pedidoMapper.updateEntityFromDTO(dto, pedidoExistente);

            // Gerenciar itens de forma inteligente
            atualizarItens(pedidoExistente, dto.getItens());

            // Recalcular valorFinal baseado na soma dos itens
            recalcularValorFinal(pedidoExistente);

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

    private void recalcularValorFinal(Pedidos pedido) {
        BigDecimal valorTotal = pedido.getItens().stream()
                .map(PedidoItem::getTotal)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        pedido.setValorFinal(valorTotal);
    }

    private void atualizarItens(Pedidos pedido, List<PedidoItemDTO> novosItensDTO) {
        // Mapear itens existentes por ID para busca rápida O(1)
        Map<Long, PedidoItem> itensExistentesMap = pedido.getItens().stream()
                .filter(item -> item.getId() != null)
                .collect(Collectors.toMap(PedidoItem::getId, item -> item));

        // Criar conjunto de IDs dos itens mantidos pelo usuário
        Set<Long> idsNovosItens = novosItensDTO.stream()
                .map(PedidoItemDTO::getId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        // Remover itens que o usuário deletou na interface (não estão mais no DTO)
        pedido.getItens().removeIf(item ->
                item.getId() != null && !idsNovosItens.contains(item.getId())
        );

        // Atualizar ou adicionar itens
        for (PedidoItemDTO itemDTO : novosItensDTO) {
            if (itemDTO.getId() != null && itensExistentesMap.containsKey(itemDTO.getId())) {
                // ATUALIZAR item existente (reutiliza objeto gerenciado pelo Hibernate)
                PedidoItem itemExistente = itensExistentesMap.get(itemDTO.getId());
                itemExistente.setQuantidade(itemDTO.getQuantidade());
                itemExistente.setDescricao(itemDTO.getDescricao());
                itemExistente.setTotal(itemDTO.getTotal());
                itemExistente.setRetirada(itemDTO.getRetirada());
            } else {
                // ADICIONAR novo item
                PedidoItem novoItem = pedidoMapper.toItemEntity(itemDTO);
                novoItem.setPedido(pedido);
                pedido.getItens().add(novoItem);
            }
        }
    }

    @Transactional
    public boolean deletar(Long id) {
        return pedidosClientsRepository.findById(id).map(pedido -> {
            pedidosClientsRepository.delete(pedido);
            return true;
        }).orElse(false);
    }


}
