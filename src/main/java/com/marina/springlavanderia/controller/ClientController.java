package com.marina.springlavanderia.controller;

import com.marina.springlavanderia.model.Client;
import com.marina.springlavanderia.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
