package com.marina.springlavanderia.controller;

import com.marina.springlavanderia.DTO.PedidosDTO;
import com.marina.springlavanderia.service.PedidosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosClientsController {

    private final PedidosService pedidosService;

    public PedidosClientsController(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    // 🔹 Listar todos os pedidos
    @GetMapping
    public ResponseEntity<List<PedidosDTO>> listarTodos() {
        List<PedidosDTO> lista = pedidosService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    // 🔹 Buscar pedidos por query (cliente, telefone ou número do pedido)
    @GetMapping("/search")
    public ResponseEntity<List<PedidosDTO>> buscar(@RequestParam(required = false) String query) {
        List<PedidosDTO> resultado = pedidosService.buscarPorQuery(query);
        return ResponseEntity.ok(resultado);
    }

    // 🔹 Buscar pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<PedidosDTO> buscarPorId(@PathVariable Long id) {
        return pedidosService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔸 Criar novo pedido
    @PostMapping
    public ResponseEntity<PedidosDTO> criar(@RequestBody PedidosDTO dto) {
        PedidosDTO criado = pedidosService.salvar(dto);
        return ResponseEntity.created(URI.create("/api/pedidos/" + criado.getId())).body(criado);
    }

    // 🔸 Atualizar pedido existente
    @PutMapping("/{id}")
    public ResponseEntity<PedidosDTO> atualizar(@PathVariable Long id, @RequestBody PedidosDTO dto) {
        return pedidosService.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔻 Deletar pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean existe = pedidosService.deletar(id);
        if (existe) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
