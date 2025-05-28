package com.marina.springlavanderia.controller;

import com.marina.springlavanderia.DTO.ClientDTO;
import com.marina.springlavanderia.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> listar() {
        return ResponseEntity.ok(clientService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> buscar(@PathVariable Long id) {
        return clientService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClientDTO> criar(@RequestBody ClientDTO dto) {
        return ResponseEntity.ok(clientService.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> atualizar(@PathVariable Long id, @RequestBody ClientDTO dto) {
        return clientService.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return clientService.deletar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
