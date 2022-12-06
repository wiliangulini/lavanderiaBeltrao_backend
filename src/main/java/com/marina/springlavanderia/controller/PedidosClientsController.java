package com.marina.springlavanderia.controller;

import com.marina.springlavanderia.model.PedidosClients;
import com.marina.springlavanderia.repository.PedidosClientsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidosClients")
@AllArgsConstructor
public class PedidosClientsController {
  private final PedidosClientsRepository pedidosClientsRepository;

  @GetMapping
  public List<PedidosClients> list() {
    return pedidosClientsRepository.findAll();
  }

//  @GetMapping("/{numberPedido}")
//  public List<PedidosClients> findByNumPedido(@PathVariable String numberPedido) {
//    return pedidosClientsRepository.findByNumberPedido(numberPedido);
//  }

  @GetMapping("/{id}")
  public ResponseEntity<PedidosClients> findById(@PathVariable Long id) {
     return pedidosClientsRepository.findById(id)
             .map(record -> ResponseEntity.ok().body(record))
             .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public void create(@RequestBody PedidosClients pedidosClients) {
    System.out.println(pedidosClients.getCliente());
    System.out.println(pedidosClients.getCidade());

    pedidosClientsRepository.save(pedidosClients);
  }
}
