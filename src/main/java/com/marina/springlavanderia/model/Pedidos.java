package com.marina.springlavanderia.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedidos {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate data;

  @Column(nullable = false)
  private Integer numberPedido;

  @Column(nullable = false)
  private String cliente;

  @Column(nullable = false)
  private String telefone;

  private String cep;
  private String cidade;
  private String rua;

  @Column(nullable = false)
  private String numCasa;

  private String bairro;
  private String complemento;
 // analisar os campos aki e remove-los tanto quantidade qnto descricao ja estao presentes em pedidoItem analisar com base nas informacoes do chatgpt
  //private Integer quantidade;
  //private String descricao;
  private String entrega_estimada;

  @Column(precision = 10, scale = 2)
  private BigDecimal total;

  private Boolean retirada;

  @Column(precision = 10, scale = 2)
  @JsonSerialize(using = ToStringSerializer.class)
  private BigDecimal valorFinal;

  private Boolean pedidoRegistrado;
  private Boolean pedidoPago;
  private Boolean pedidoRetirado;

  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PedidoItem> itens = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public Integer getNumberPedido() {
    return numberPedido;
  }

  public void setNumberPedido(Integer numberPedido) {
    this.numberPedido = numberPedido;
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getNumCasa() {
    return numCasa;
  }

  public void setNumCasa(String numCasa) {
    this.numCasa = numCasa;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  /*public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }*/

  public String getEntrega_estimada() {
    return entrega_estimada;
  }

  public void setEntrega_estimada(String entrega_estimada) {
    this.entrega_estimada = entrega_estimada;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public Boolean getRetirada() {
    return retirada;
  }

  public void setRetirada(Boolean retirada) {
    this.retirada = retirada;
  }

  public BigDecimal getValorFinal() {
    return valorFinal;
  }

  public void setValorFinal(BigDecimal valorFinal) {
    this.valorFinal = valorFinal;
  }

  public Boolean getPedidoRegistrado() {
    return pedidoRegistrado;
  }

  public void setPedidoRegistrado(Boolean pedidoRegistrado) {
    this.pedidoRegistrado = pedidoRegistrado;
  }

  public Boolean getPedidoPago() {
    return pedidoPago;
  }

  public void setPedidoPago(Boolean pedidoPago) {
    this.pedidoPago = pedidoPago;
  }

  public Boolean getPedidoRetirado() {
    return pedidoRetirado;
  }

  public void setPedidoRetirado(Boolean pedidoRetirado) {
    this.pedidoRetirado = pedidoRetirado;
  }

  public List<PedidoItem> getItens() {
    return itens;
  }

  public void setItens(List<PedidoItem> itens) {
    this.itens = itens;
  }

}

