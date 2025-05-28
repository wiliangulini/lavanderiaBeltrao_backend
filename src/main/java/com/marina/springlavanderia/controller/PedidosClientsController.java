package com.marina.springlavanderia.controller;

import com.marina.springlavanderia.DTO.PedidosDTO;
import com.marina.springlavanderia.service.PedidosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidosClientsController {

    private final PedidosService pedidosService;

    public PedidosClientsController(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    @PostMapping
    public ResponseEntity<PedidosDTO> criar(@RequestBody PedidosDTO dto) {
        return ResponseEntity.ok(pedidosService.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidosDTO> atualizar(@PathVariable Long id, @RequestBody PedidosDTO dto) {
        System.out.println("Atualizando pedido com ID: " + id);
        return pedidosService.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PedidosDTO>> listar() {
        return ResponseEntity.ok(pedidosService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidosDTO> buscar(@PathVariable Long id) {
        PedidosDTO dto = pedidosService.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pedidosService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
