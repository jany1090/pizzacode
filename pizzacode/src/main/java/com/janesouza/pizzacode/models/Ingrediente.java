package com.janesouza.pizzacode.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIngrediente;

    private String nome;
    private String tipo;
    private Float preco;



    public Ingrediente(Integer idIngrediente, String nome, String tipo, Float preco) {
        this.idIngrediente = idIngrediente;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }


    public Integer getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}

