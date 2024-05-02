package com.janesouza.pizzacode.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pizza_pedida_has_ingrediente")
public class PizzaPedida_has_Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pizza_pedida")
    private PizzaPedida pizzaPedida;

    @ManyToOne
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;




    public PizzaPedida_has_Ingrediente(PizzaPedida pizzaPedida, Ingrediente ingrediente) {
        this.pizzaPedida = pizzaPedida;
        this.ingrediente = ingrediente;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PizzaPedida getPizzaPedida() {
        return pizzaPedida;
    }

    public void setPizzaPedida(PizzaPedida pizzaPedida) {
        this.pizzaPedida = pizzaPedida;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
}

