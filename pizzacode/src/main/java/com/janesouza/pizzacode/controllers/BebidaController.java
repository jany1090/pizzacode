package com.janesouza.pizzacode.controllers;

import com.janesouza.pizzacode.models.Bebida;
import com.janesouza.pizzacode.services.BebidaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bebidas")
public class BebidaController {

    private final BebidaService bebidaService;

    public BebidaController(BebidaService bebidaService) {
        this.bebidaService = bebidaService;
    }

    @PostMapping
    public ResponseEntity<Bebida> criarBebida(@RequestBody Bebida bebida){
        Bebida bebidaDb = bebidaService.criarBebida(bebida);
        return ResponseEntity.status(HttpStatus.CREATED).body(bebidaDb);
    }

    @GetMapping
    public ResponseEntity<List<Bebida>> exibirBebidas(){
        List<Bebida> bebidas = bebidaService.exibirBebidas();
        return ResponseEntity.status(HttpStatus.OK).body(bebidas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bebida> exibirBebidaPorId(@PathVariable Long id){
        Bebida bebidaDb = bebidaService.exibirBebidaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(bebidaDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bebida> atualizarBebida(@PathVariable Long id, @RequestBody Bebida bebida){
        Bebida bebidaDb = bebidaService.atualizarBebida(id, bebida);
        return ResponseEntity.status(HttpStatus.OK).body(bebidaDb);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarBebida(@PathVariable Long id){
        bebidaService.deletarBebida(id);
        return ResponseEntity.status(HttpStatus.OK).body("Bebida deletada com sucesso!");
    }
}