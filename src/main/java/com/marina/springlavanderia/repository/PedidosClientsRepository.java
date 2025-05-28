package com.marina.springlavanderia.repository;

import com.marina.springlavanderia.model.Pedidos;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidosClientsRepository extends JpaRepository<Pedidos, Long> {

    //List<PedidosClients> findByNumberPedido(String numberPedido);

    @EntityGraph(attributePaths = "itens")
    List<Pedidos> findAll(); // força o carregamento de itens

    @EntityGraph(attributePaths = "itens")
    Optional<Pedidos> findById(Long id);

}
