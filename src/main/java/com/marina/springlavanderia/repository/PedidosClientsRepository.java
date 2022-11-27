package com.marina.springlavanderia.repository;

import com.marina.springlavanderia.model.PedidosClients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosClientsRepository extends JpaRepository<PedidosClients, Long> {

}
