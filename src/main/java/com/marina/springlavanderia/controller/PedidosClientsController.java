package com.marina.springlavanderia.controller;

import com.marina.springlavanderia.model.Pedidos;
import com.marina.springlavanderia.repository.PedidosClientsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@AllArgsConstructor
public class PedidosClientsController {
  private final PedidosClientsRepository pedidosClientsRepository;

  @GetMapping
  public List<Pedidos> list() {
    return pedidosClientsRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pedidos> findById(@PathVariable Long id) {
     return pedidosClientsRepository.findById(id)
             .map(record -> ResponseEntity.ok().body(record))
             .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Pedidos create(@RequestBody Pedidos pedidos) {
      System.out.println(pedidos);

      return pedidosClientsRepository.save(pedidos);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Pedidos> update(@PathVariable Long id, @RequestBody Pedidos pedidos) {
    return pedidosClientsRepository.findById(id)
            .map(recordFound -> {
              recordFound.setCliente(pedidos.getCliente());
              recordFound.setData(pedidos.getData());
              recordFound.setNumberPedido(pedidos.getNumberPedido());
              recordFound.setTelefone(pedidos.getTelefone());
              recordFound.setCep(pedidos.getCep());
              recordFound.setNumCasa(pedidos.getNumCasa());
              recordFound.setRua(pedidos.getRua());
              recordFound.setCidade(pedidos.getCidade());
              recordFound.setBairro(pedidos.getBairro());
              recordFound.setComplemento(pedidos.getComplemento());
              recordFound.setQuantidade(pedidos.getQuantidade());
              recordFound.setDescricao(pedidos.getDescricao());
              recordFound.setTotal(pedidos.getTotal());
              recordFound.setQuantidade1(pedidos.getQuantidade1());
              recordFound.setDescricao1(pedidos.getDescricao1());
              recordFound.setTotal1(pedidos.getTotal1());
              recordFound.setQuantidade2(pedidos.getQuantidade2());
              recordFound.setDescricao2(pedidos.getDescricao2());
              recordFound.setTotal2(pedidos.getTotal2());
              recordFound.setQuantidade3(pedidos.getQuantidade3());
              recordFound.setDescricao3(pedidos.getDescricao3());
              recordFound.setTotal3(pedidos.getTotal3());
              recordFound.setQuantidade4(pedidos.getQuantidade4());
              recordFound.setDescricao4(pedidos.getDescricao4());
              recordFound.setTotal4(pedidos.getTotal4());
              recordFound.setQuantidade5(pedidos.getQuantidade5());
              recordFound.setDescricao5(pedidos.getDescricao5());
              recordFound.setTotal5(pedidos.getTotal5());
              recordFound.setValorFinal(pedidos.getValorFinal());
              recordFound.setPedidoRegistrado(pedidos.getPedidoRegistrado());
              recordFound.setPedidoPago(pedidos.getPedidoPago());
              recordFound.setPedidoRetirado(pedidos.getPedidoRetirado());
              recordFound.setRetirada(pedidos.getRetirada());
              recordFound.setRetirada1(pedidos.getRetirada1());
              recordFound.setRetirada2(pedidos.getRetirada2());
              recordFound.setRetirada3(pedidos.getRetirada3());
              recordFound.setRetirada4(pedidos.getRetirada4());
              recordFound.setRetirada5(pedidos.getRetirada5());
              recordFound.setEntrega_estimada(pedidos.getEntrega_estimada());

              Pedidos updated = pedidosClientsRepository.save(recordFound);
              return ResponseEntity.ok().body(updated);
            })
            .orElse(ResponseEntity.notFound().build());

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
      return pedidosClientsRepository.findById(id)
              .map(recordFound -> {

                  pedidosClientsRepository.deleteById(id);
                  return ResponseEntity.noContent().<Void>build();
              })
              .orElse(ResponseEntity.notFound().build());
  }

}
