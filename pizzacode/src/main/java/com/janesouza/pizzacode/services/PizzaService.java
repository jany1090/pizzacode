package com.janesouza.pizzacode.services;

import com.janesouza.pizzacode.models.Pizza;
import com.janesouza.pizzacode.repositories.PizzaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public Pizza criarPizza(Pizza pizza) {
        Optional<Pizza> pizzaExistente = pizzaRepository.findByNome(pizza.getNome());
        if (pizzaExistente.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe uma pizza com esse nome.");
        }
        return pizzaRepository.save(pizza);
}

    public List<Pizza> exibirPizzas() {
        List<Pizza> pizzas = pizzaRepository.findAll();
        return pizzas.isEmpty() ? Collections.emptyList() : pizzas;
    }

    public Pizza exibirPizzaPorId(Long id) {
        return pizzaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pizza não encontrada."));
    }

    public Pizza atualizarPizza(Long id, Pizza pizza) {
        Pizza pizzaDb = pizzaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pizza não encontrada."));

        pizzaDb.setNome(pizza.getNome());
        pizzaDb.setPrecoBase(pizza.getPrecoBase());
        pizzaDb.setPersonalizada(pizza.isPersonalizada());
        pizzaDb.setIngredientes(pizza.getIngredientes());

        return pizzaRepository.save(pizzaDb);
    }

    public void deletarPizza(Long id) {
        Pizza pizzaDb = pizzaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pizza não encontrada."));
        pizzaRepository.delete(pizzaDb);
    }

}