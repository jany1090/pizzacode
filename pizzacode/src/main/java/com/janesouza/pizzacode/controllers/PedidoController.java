package com.janesouza.pizzacode.controllers;

import com.janesouza.pizzacode.models.Pedido;
import com.janesouza.pizzacode.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido){
        Pedido novoPedido = pedidoService.criarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> exibirPedidos(){
        List<Pedido> pedidos = pedidoService.exibirPedidos();
        return ResponseEntity.status(HttpStatus.OK).body(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> exibirPedidoPorId(@PathVariable Long id){
        Pedido pedido = pedidoService.exibirPedidoPorId(id);
        if (pedido != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pedido);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido){
        Pedido pedidoAtualizado = pedidoService.atualizarPedido(id, pedido);
        if (pedidoAtualizado != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pedidoAtualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id){
        boolean sucesso = pedidoService.deletarPedido(id);
        if (sucesso) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}