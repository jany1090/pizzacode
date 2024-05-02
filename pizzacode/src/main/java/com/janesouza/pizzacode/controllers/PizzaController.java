package com.janesouza.pizzacode.controllers;

import com.janesouza.pizzacode.models.Pizza;
import com.janesouza.pizzacode.services.PizzaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public ResponseEntity<Pizza> criarPizza(@RequestBody Pizza pizza){
        Pizza pizzaDb;
        pizzaDb = pizzaService.criarPizza(pizza);
        return ResponseEntity.status(HttpStatus.CREATED).body(pizzaDb);
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> exibirPizzas(){
        List<Pizza> pizzas = pizzaService.exibirPizzas();
        return ResponseEntity.status(HttpStatus.OK).body(pizzas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> exibirPizzaPorId(@PathVariable Long id){
        Pizza pizza = pizzaService.exibirPizzaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(pizza);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizza> atualizarPizza(@PathVariable Long id, @RequestBody Pizza pizza){
        Pizza pizzaDb = pizzaService.atualizarPizza(id, pizza);
        return ResponseEntity.status(HttpStatus.OK).body(pizzaDb);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPizza(@PathVariable Long id){
        pizzaService.deletarPizza(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pizza deletada com sucesso!");
    }

}