package com.janesouza.pizzacode.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pizzapedida")
public class PizzaPedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPizzaPedida;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_pizza")
    private Pizza pizza;
    private Byte quantidade;


    public PizzaPedida() {
    }


    public PizzaPedida(Pedido pedido, Pizza pizza, Tamanho tamanho, Byte quantidade) {
        this.pedido = pedido;
        this.pizza = pizza;
        this.quantidade = quantidade;
    }


    public Long getIdPizzaPedida() {
        return idPizzaPedida;
    }

    public void setIdPizzaPedida(Long idPizzaPedida) {
        this.idPizzaPedida = idPizzaPedida;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }


    public Byte getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Byte quantidade) {
        this.quantidade = quantidade;
    }
}

