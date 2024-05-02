package com.janesouza.pizzacode.services;

import com.janesouza.pizzacode.models.Cliente;
import com.janesouza.pizzacode.repositories.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criarCliente(Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findByLogin(cliente.getLogin());
        if (clienteExistente.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um cliente com esse login.");
        }
        return clienteRepository.save(cliente);
    }


    public List<Cliente> exibirClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.isEmpty() ? Collections.emptyList() : clientes;
    }

    public Cliente exibirClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

    public Cliente atualizarCliente(Long id, Cliente cliente) {
        Cliente clienteDb = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        clienteDb.setTelefone(cliente.getTelefone());
        clienteDb.setLogin(cliente.getLogin());
        clienteDb.setNome(cliente.getNome());
        clienteDb.setEndereco(cliente.getEndereco());
        clienteDb.setSenha(cliente.getSenha());

        return clienteRepository.save(clienteDb);
    }

    public void deletarCliente(Long id) {
        Cliente clienteDb = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        clienteRepository.delete(clienteDb);
    }

}