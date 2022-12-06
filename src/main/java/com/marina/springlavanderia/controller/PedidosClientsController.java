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

  @PutMapping("/{id}")
  public ResponseEntity<PedidosClients> update(@PathVariable Long id, @RequestBody PedidosClients pedidosClients) {
    return pedidosClientsRepository.findById(id)
            .map(recordFound -> {
              recordFound.setCliente(pedidosClients.getCliente());
              recordFound.setData(pedidosClients.getData());
              recordFound.setNumberPedido(pedidosClients.getNumberPedido());
              recordFound.setTelefone(pedidosClients.getTelefone());
              recordFound.setCep(pedidosClients.getCep());
              recordFound.setNumCasa(pedidosClients.getNumCasa());
              recordFound.setRua(pedidosClients.getRua());
              recordFound.setCidade(pedidosClients.getCidade());
              recordFound.setBairro(pedidosClients.getBairro());
              recordFound.setComplemento(pedidosClients.getComplemento());
              recordFound.setQuantidade(pedidosClients.getQuantidade());
              recordFound.setDescricao(pedidosClients.getDescricao());
              recordFound.setTotal(pedidosClients.getTotal());
              recordFound.setQuantidade1(pedidosClients.getQuantidade1());
              recordFound.setDescricao1(pedidosClients.getDescricao1());
              recordFound.setTotal1(pedidosClients.getTotal1());
              recordFound.setQuantidade2(pedidosClients.getQuantidade2());
              recordFound.setDescricao2(pedidosClients.getDescricao2());
              recordFound.setTotal2(pedidosClients.getTotal2());
              recordFound.setQuantidade3(pedidosClients.getQuantidade3());
              recordFound.setDescricao3(pedidosClients.getDescricao3());
              recordFound.setTotal3(pedidosClients.getTotal3());
              recordFound.setQuantidade4(pedidosClients.getQuantidade4());
              recordFound.setDescricao4(pedidosClients.getDescricao4());
              recordFound.setTotal4(pedidosClients.getTotal4());
              recordFound.setQuantidade5(pedidosClients.getQuantidade5());
              recordFound.setDescricao5(pedidosClients.getDescricao5());
              recordFound.setTotal5(pedidosClients.getTotal5());

              PedidosClients updated = pedidosClientsRepository.save(recordFound);
              return ResponseEntity.ok().body(updated);
            })
            .orElse(ResponseEntity.notFound().build());

  }
}
