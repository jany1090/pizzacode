package com.janesouza.pizzacode.services;

import com.janesouza.pizzacode.models.Bebida;
import com.janesouza.pizzacode.repositories.BebidaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BebidaService {
    private final BebidaRepository bebidaRepository;

    public BebidaService(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    public Bebida criarBebida(Bebida bebida) {
        Optional<Bebida> bebidaExistente = bebidaRepository.findByNome(String.valueOf(bebida.getNome()));
        if (bebidaExistente.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe uma bebida com esse nome.");
        }
        return bebidaRepository.save(bebida);
    }

    public List<Bebida> exibirBebidas() {
        List<Bebida> bebidas = bebidaRepository.findAll();
        return bebidas.isEmpty() ? Collections.emptyList() : bebidas;
    }

    public Bebida exibirBebidaPorId(Long id) {
        return bebidaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bebida não encontrada."));
    }

    public Bebida atualizarBebida(Long id, Bebida bebida) {
        Bebida bebidaDb = bebidaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bebida não encontrada."));

        bebidaDb.setNome(String.valueOf(bebida.getNome()));
        bebidaDb.setPreco(bebida.getPreco());

        return bebidaRepository.save(bebidaDb);
    }

    public void deletarBebida(Long id) {
        Bebida bebidaDb = bebidaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bebida não encontrada."));
        bebidaRepository.delete(bebidaDb);
    }
}

