package com.janesouza.pizzacode.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_fornada")
    private Fornada fornada;

    private LocalDateTime dataHora;


    public Pedido() {
        this.dataHora = LocalDateTime.now();
    }

    public Pedido(Cliente cliente, Fornada fornada) {
        this.cliente = cliente;
        this.fornada = fornada;
        this.dataHora = LocalDateTime.now();
    }


    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getIdCliente() {
        return cliente;
    }

    public void setIdCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fornada getFornada() {
        return fornada;
    }

    public void setFornada(Fornada fornada) {
        this.fornada = fornada;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }


    public Iterable<? extends BebidaPedida> getBebidaPedidos() {
        return null;
    }

    public Iterable<? extends PizzaPedida> getPizzaPedidos() {
        return null;
    }

    public void setPizzaPedidos(Iterable<? extends PizzaPedida> pizzaPedidos) {
    }

    public void setBebidaPedidos(Iterable<? extends BebidaPedida> bebidaPedidos) {
    }


}

