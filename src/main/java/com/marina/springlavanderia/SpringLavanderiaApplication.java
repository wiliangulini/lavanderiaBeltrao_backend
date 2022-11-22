package com.marina.springlavanderia;

import com.marina.springlavanderia.model.Client;
import com.marina.springlavanderia.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringLavanderiaApplication {

  public static void main(String[] args) {

    SpringApplication.run(SpringLavanderiaApplication.class, args);
  }

  @Bean
  CommandLineRunner initDatabase(ClientRepository clientRepository) {
    return args -> {
      clientRepository.deleteAll();

      Client c = new Client();
      c.setCliente("Wilian Gulini");
      c.setTelefone("46991270213");
      c.setCep("85550000");
      c.setCidade("Coronel Vivida");
      c.setRua("Rua Dolfino Panatto");
      c.setNumCasa("221");
      c.setBairro("Rodolfo Ferri");
      c.setComplemento("perto da rodoviaria");

      clientRepository.save(c);

    };

  }

}
