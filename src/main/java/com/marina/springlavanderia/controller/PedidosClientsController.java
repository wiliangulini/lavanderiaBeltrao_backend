package com.marina.springlavanderia.controller;

import com.marina.springlavanderia.model.PedidosClients;
import com.marina.springlavanderia.repository.PedidosClientsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidosClients/")
@AllArgsConstructor
public class PedidosClientsController {
  private final PedidosClientsRepository pedidosClientsRepository;

  @GetMapping
  public List<PedidosClients> list() {
    return pedidosClientsRepository.findAll();
  }

  @PostMapping
  public void create(@RequestBody PedidosClients pedidosClients) {
    System.out.println(pedidosClients.getCliente());
    System.out.println(pedidosClients.getCidade());

    pedidosClientsRepository.save(pedidosClients);
  }
}
