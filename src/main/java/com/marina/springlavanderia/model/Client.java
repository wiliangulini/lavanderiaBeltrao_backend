package com.marina.springlavanderia.model;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 200, nullable = false)
  private String cliente;

  @Column(length = 12, nullable = false)
  private String telefone;

  @Column(length = 10)
  private String cep;

  @Column(length = 150)
  private String cidade;

  @Column(length = 150)
  private String rua;

  @Column(length = 10)
  private String numCasa;

  @Column(length = 150)
  private String bairro;

  @Column(length = 150)
  private String complemento;

  // Getters e Setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getCliente() { return cliente; }
  public void setCliente(String cliente) { this.cliente = cliente; }

  public String getTelefone() { return telefone; }
  public void setTelefone(String telefone) { this.telefone = telefone; }

  public String getCep() { return cep; }
  public void setCep(String cep) { this.cep = cep; }

  public String getCidade() { return cidade; }
  public void setCidade(String cidade) { this.cidade = cidade; }

  public String getRua() { return rua; }
  public void setRua(String rua) { this.rua = rua; }

  public String getNumCasa() { return numCasa; }
  public void setNumCasa(String numCasa) { this.numCasa = numCasa; }

  public String getBairro() { return bairro; }
  public void setBairro(String bairro) { this.bairro = bairro; }

  public String getComplemento() { return complemento; }
  public void setComplemento(String complemento) { this.complemento = complemento; }
}
