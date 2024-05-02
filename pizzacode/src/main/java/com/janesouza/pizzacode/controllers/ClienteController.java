package com.janesouza.pizzacode.controllers;

import com.janesouza.pizzacode.models.Cliente;
import com.janesouza.pizzacode.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente clienteDb = clienteService.criarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDb);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> exibirClientes() {
        List<Cliente> clientes = clienteService.exibirClientes();
        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> exibirClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteService.exibirClientePorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteDb = clienteService.atualizarCliente(id, cliente);
        return ResponseEntity.status(HttpStatus.OK).body(clienteDb);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
    }
}