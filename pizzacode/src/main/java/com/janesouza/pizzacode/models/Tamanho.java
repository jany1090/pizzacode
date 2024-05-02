package com.janesouza.pizzacode.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tamanho")
public class Tamanho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTamanho;

    private String nome;
    private Float desconto;


    public Tamanho() {
    }

    public Tamanho(String nome, Float desconto) {
        this.nome = nome;
        this.desconto = desconto;
    }


    public Long getIdTamanho() {
        return idTamanho;
    }

    public void setIdTamanho(Long idTamanho) {
        this.idTamanho = idTamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }
}
