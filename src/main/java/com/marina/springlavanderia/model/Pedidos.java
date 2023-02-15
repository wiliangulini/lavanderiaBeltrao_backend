package com.marina.springlavanderia.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pedidos")
public class Pedidos {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length =  11, nullable = false)
  private String data;

  @Column(length =  200, nullable = false)
  private String numberPedido;

  @Column(length =  200, nullable = false)
  private String cliente;

  @Column(length =  12, nullable = false)
  private String telefone;

  @Column(length =  10)
  private String cep;

  @Column(length =  150)
  private String cidade;

  @Column(length =  150)
  private String rua;

  @Column(length =  10, nullable = false)
  private String numCasa;

  @Column(length =  150)
  private String bairro;

  @Column(length =  150)
  private String complemento;

  @Column(length =  100)
  private String quantidade;

  @Column(length =  150)
  private String descricao;

  @Column(length =  150)
  private String entrega_estimada;

  @Column(length =  100)
  private Number total;

  @Column(length =  20)
  private Boolean retirada;

  @Column(length =  100)
  private String quantidade1;

  @Column(length =  150)
  private String descricao1;

  @Column(length =  100)
  private Number total1;

  @Column(length =  20)
  private Boolean retirada1;

  @Column(length =  100)
  private String quantidade2;

  @Column(length =  150)
  private String descricao2;

  @Column(length =  100)
  private Number total2;

  @Column(length =  20)
  private Boolean retirada2;

  @Column(length =  100)
  private String quantidade3;

  @Column(length =  150)
  private String descricao3;

  @Column(length =  100)
  private Number total3;

  @Column(length =  20)
  private Boolean retirada3;

  @Column(length =  100)
  private String quantidade4;

  @Column(length =  150)
  private String descricao4;

  @Column(length =  100)
  private Number total4;

  @Column(length =  20)
  private Boolean retirada4;

  @Column(length =  100)
  private String quantidade5;

  @Column(length =  150)
  private String descricao5;

  @Column(length =  100)
  private Number total5;

  @Column(length =  20)
  private Boolean retirada5;

  @Column(length =  100)
  private Number valorFinal;

  @Column(length =  20)
  private Boolean pedidoRegistrado;

  @Column(length =  20)
  private Boolean pedidoPago;

  @Column(length =  20)
  private Boolean pedidoRetirado;

}
