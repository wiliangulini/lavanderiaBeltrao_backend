package com.marina.springlavanderia.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PedidosDTO {
    private Long id;
    private LocalDate data;
    private Integer numberPedido;
    private String cliente;
    private String telefone;
    private String cep;
    private String cidade;
    private String rua;
    private String numCasa;
    private String bairro;
    private String complemento;
    private String entrega_estimada;
    private BigDecimal total;
    private Boolean retirada;
    private BigDecimal valorFinal;
    private Boolean pedidoRegistrado;
    private Boolean pedidoPago;
    private Boolean pedidoRetirado;
    private List<PedidoItemDTO> itens;

    // Construtor completo
    public PedidosDTO(Long id, LocalDate data, Integer numberPedido, String cliente, String telefone, String cep,
                      String cidade, String rua, String numCasa, String bairro, String complemento, String entrega_estimada, BigDecimal total, Boolean retirada, BigDecimal valorFinal,
                      Boolean pedidoRegistrado, Boolean pedidoPago, Boolean pedidoRetirado,
                      List<PedidoItemDTO> itens) {
        this.id = id;
        this.data = data;
        this.numberPedido = numberPedido;
        this.cliente = cliente;
        this.telefone = telefone;
        this.cep = cep;
        this.cidade = cidade;
        this.rua = rua;
        this.numCasa = numCasa;
        this.bairro = bairro;
        this.complemento = complemento;
        this.entrega_estimada = entrega_estimada;
        this.total = total;
        this.retirada = retirada;
        this.valorFinal = valorFinal;
        this.pedidoRegistrado = pedidoRegistrado;
        this.pedidoPago = pedidoPago;
        this.pedidoRetirado = pedidoRetirado;
        this.itens = itens;
    }

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public Integer getNumberPedido() { return numberPedido; }
    public void setNumberPedido(Integer numberPedido) { this.numberPedido = numberPedido; }

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

    public String getEntrega_estimada() { return entrega_estimada; }
    public void setEntrega_estimada(String entrega_estimada) { this.entrega_estimada = entrega_estimada; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public Boolean getRetirada() { return retirada; }
    public void setRetirada(Boolean retirada) { this.retirada = retirada; }

    public BigDecimal getValorFinal() { return valorFinal; }
    public void setValorFinal(BigDecimal valorFinal) { this.valorFinal = valorFinal; }

    public Boolean getPedidoRegistrado() { return pedidoRegistrado; }
    public void setPedidoRegistrado(Boolean pedidoRegistrado) { this.pedidoRegistrado = pedidoRegistrado; }

    public Boolean getPedidoPago() { return pedidoPago; }
    public void setPedidoPago(Boolean pedidoPago) { this.pedidoPago = pedidoPago; }

    public Boolean getPedidoRetirado() { return pedidoRetirado; }
    public void setPedidoRetirado(Boolean pedidoRetirado) { this.pedidoRetirado = pedidoRetirado; }

    public List<PedidoItemDTO> getItens() { return itens; }
    public void setItens(List<PedidoItemDTO> itens) { this.itens = itens; }
}
