package com.marina.springlavanderia.DTO;

import java.math.BigDecimal;

public class PedidoItemDTO {
    private Long id;
    private Integer quantidade;
    private String descricao;
    private BigDecimal total;
    private Boolean retirada;

    // Constructor
    public PedidoItemDTO(Long id, Integer quantidade, String descricao, BigDecimal total, Boolean retirada) {
        this.id = id;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.total = total;
        this.retirada = retirada;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
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

}
