package com.marina.springlavanderia.repository;

import com.marina.springlavanderia.model.PedidosClients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface PedidosClientsRepository extends JpaRepository<PedidosClients, Long> {

    //List<PedidosClients> findByNumberPedido(String numberPedido);
}
