package com.marina.springlavanderia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PedidosClients {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty("id")
  private Long id;

  @Column(length =  11)
  private String data;

  @Column(length =  200)
  private String numberPedido;

  @Column(length =  200)
  private String cliente;

  @Column(length =  15)
  private String telefone;

  @Column(length =  10)
  @JsonProperty("cep")
  private String cep;

  @Column(length =  150)
  @JsonProperty("endereco.cidade")
  private String cidade;

  @Column(length =  150)
  private String rua;

  @Column(length =  10)
  private String numCasa;

  @Column(length =  150)
  private String bairro;

  @Column(length =  150)
  private String complemento;

  @Column(length =  100)
  private String quantidade;

  @Column(length =  150)
  private String descricao;

  @Column(length =  200)
  private String total;

  @Column(length =  100)
  private String quantidade1;

  @Column(length =  150)
  private String descricao1;

  @Column(length =  200)
  private String total1;

  @Column(length =  100)
  private String quantidade2;

  @Column(length =  150)
  private String descricao2;

  @Column(length =  200)
  private String total2;

  @Column(length =  100)
  private String quantidade3;

  @Column(length =  150)
  private String descricao3;

  @Column(length =  200)
  private String total3;

  @Column(length =  100)
  private String quantidade4;

  @Column(length =  150)
  private String descricao4;

  @Column(length =  200)
  private String total4;

  @Column(length =  100)
  private String quantidade5;

  @Column(length =  150)
  private String descricao5;

  @Column(length =  200)
  private String total5;

}
