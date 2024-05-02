package com.janesouza.pizzacode.models;

import jakarta.persistence.*;

@Entity
@Table(name = "bebidapedida")
public class BebidaPedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_bebida")
    private Bebida bebida;

    private Integer quantidade;


    public BebidaPedida() {
    }

    public BebidaPedida(Pedido pedido, Bebida bebida, Integer quantidade) {
        this.pedido = pedido;
        this.bebida = bebida;
        this.quantidade = quantidade;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

