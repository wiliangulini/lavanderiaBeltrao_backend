package com.marina.springlavanderia.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clientes")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length =  200, nullable = false)
  private String cliente;

  @Column(length =  12, nullable = false)
  private String telefone;

  @Column(length =  10)
  private String cep;

  @Column(length =  150, nullable = false)
  private String cidade;

  @Column(length =  150, nullable = false)
  private String rua;

  @Column(length =  10, nullable = false)
  private String numCasa;

  @Column(length =  150, nullable = false)
  private String bairro;

  @Column(length =  150)
  private String complemento;
}
