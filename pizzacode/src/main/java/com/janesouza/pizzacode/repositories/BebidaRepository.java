package com.janesouza.pizzacode.repositories;

import com.janesouza.pizzacode.models.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long> {
    Optional<Bebida> findByNome(String nome);
}

