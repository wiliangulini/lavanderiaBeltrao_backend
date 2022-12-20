package com.marina.springlavanderia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLavanderiaApplication {

  public static void main(String[] args) {

    SpringApplication.run(SpringLavanderiaApplication.class, args);
  }

//  @Bean
//  CommandLineRunner initDatabase(PedidosClientsRepository pedidosClientsRepository) {
//    return args -> {
//      pedidosClientsRepository.deleteAll();
//
//      PedidosClients c = new PedidosClients();
//      c.setData("30/11/2022");
//      c.setNumberPedido("1");
//      c.setCliente("Wilian Gulini");
//      c.setTelefone("46991270213");
//      c.setCep("85550000");
//      c.setCidade("Coronel Vivida");
//      c.setRua("Rua Dolfino Panatto");
//      c.setNumCasa("221");
//      c.setBairro("Rodolfo Ferri");
//      c.setComplemento("perto da rodoviaria");
//      c.setQuantidade("duas peças");
//      c.setDescricao("Um par de lençois");
//      c.setTotal("50,00");
//
//      pedidosClientsRepository.save(c);
//
//    };
//
//  }

//  @Bean
//  CommandLineRunner initDatabase(ClientRepository clientRepository) {
//    return args -> {
//      clientRepository.deleteAll();
//
//      Client c = new Client();
//      c.setCliente("Wilian Gulini");
//      c.setTelefone("46991270213");
//      c.setCep("85550000");
//      c.setCidade("Coronel Vivida");
//      c.setRua("Rua Dolfino Panatto");
//      c.setNumCasa("221");
//      c.setBairro("Rodolfo Ferri");
//      c.setComplemento("perto da rodoviaria");
//
//      clientRepository.save(c);
//
//    };
//
//  }


}
