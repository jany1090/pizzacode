package com.janesouza.pizzacode.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPizza;

    private String nome;
    private Float precoBase;
    private Boolean personalizada;


    public Pizza() {
    }

    public Pizza(String nome, Float precoBase, Boolean personalizada) {
        this.nome = nome;
        this.precoBase = precoBase;
        this.personalizada = personalizada;
    }


    public Long getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(Long idPizza) {
        this.idPizza = idPizza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Float precoBase) {
        this.precoBase = precoBase;
    }

    public Boolean getPersonalizada() {
        return personalizada;
    }

    public void setPersonalizada(Boolean personalizada) {
        this.personalizada = personalizada;
    }

    public Object getIngredientes() {
        return null;
    }

    public void setIngredientes(Object ingredientes) {
    }

    public Boolean isPersonalizada() {
        return null;
    }
}
