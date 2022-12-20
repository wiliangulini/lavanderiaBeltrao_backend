package com.marina.springlavanderia.controller;

import com.marina.springlavanderia.model.Client;
import com.marina.springlavanderia.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
public class ClientController {
  private final ClientRepository clientRepository;

  @GetMapping
  public List<Client> list() {
    return clientRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Client> findById(@PathVariable Long id) {
    return clientRepository.findById(id)
       .map(client -> ResponseEntity.ok(client))
       .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Client create(@RequestBody Client client) {
    System.out.println(client);

    return clientRepository.save(client);
//    return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(client)); nesse caso em particular do create como nao estamos manuseando response, nao estamos adicionando cabecalho, O RESPONSESTATUS, é uma alternativa do ResponseEntity, a vantagem de usar o responseentity é caso vc precise manusear header, ou informacoes do response podemos fazer isso, mas como so queremos o status e nao vamos manusear o response, ai podemos declarar a anotacao @ResponseStatus
  }

  @PutMapping("/{id}")
  public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
    return clientRepository.findById(id)
            .map(recordFound -> {
              recordFound.setCliente(client.getCliente());
              recordFound.setTelefone(client.getTelefone());
              recordFound.setCep(client.getCep());
              recordFound.setNumCasa(client.getNumCasa());
              recordFound.setRua(client.getRua());
              recordFound.setCidade(client.getCidade());
              recordFound.setBairro(client.getBairro());
              recordFound.setComplemento(client.getComplemento());

              Client updated = clientRepository.save(recordFound);
              return ResponseEntity.ok().body(updated);
            })
            .orElse(ResponseEntity.notFound().build());
  }

}
