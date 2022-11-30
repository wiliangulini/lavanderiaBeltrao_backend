package com.marina.springlavanderia.controller;

import com.marina.springlavanderia.model.Client;
import com.marina.springlavanderia.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients/")
@AllArgsConstructor
public class ClientController {
  private final ClientRepository clientRepository;

  @GetMapping
  public List<Client> list() {
    return clientRepository.findAll();
  }

  @PostMapping
  public void create(@RequestBody Client client) {
    System.out.println(client.getCliente());
    System.out.println(client.getRua());

    clientRepository.save(client);
  }
}
