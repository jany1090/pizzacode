package com.janesouza.pizzacode.models;

import jakarta.persistence.*;

@Entity
@Table(name = "fornada")
public class Fornada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte idFornada;
    private Byte numFornada;
    private Byte qtdPizzas;


    public Fornada() {
    }

    public Fornada(Byte numFornada, Byte qtdPizzas) {
        this.numFornada = numFornada;
        this.qtdPizzas = qtdPizzas;
    }


    public Byte getIdFornada() {
        return idFornada;
    }

    public void setIdFornada(Byte idFornada) {
        this.idFornada = idFornada;
    }

    public Byte getNumFornada() {
        return numFornada;
    }

    public void setNumFornada(Byte numFornada) {
        this.numFornada = numFornada;
    }

    public Byte getQtdPizzas() {
        return qtdPizzas;
    }

    public void setQtdPizzas(Byte qtdPizzas) {
        this.qtdPizzas = qtdPizzas;
    }
}

