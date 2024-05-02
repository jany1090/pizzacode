package com.janesouza.pizzacode.models;


import jakarta.persistence.*;

@Entity
@Table(name = "bebida")
public class Bebida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBebida;
    private String nome;
    private Float preco;


    public Bebida() {
    }

    public Bebida(String nome, Float preco) {
        this.nome = nome;
        this.preco = preco;
    }


    public Integer getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(Integer idBebida) {
        this.idBebida = idBebida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}

