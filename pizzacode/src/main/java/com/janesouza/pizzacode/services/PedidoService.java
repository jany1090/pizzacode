package com.janesouza.pizzacode.services;


import com.janesouza.pizzacode.models.*;
import com.janesouza.pizzacode.repositories.BebidaRepository;
import com.janesouza.pizzacode.repositories.ClienteRepository;
import com.janesouza.pizzacode.repositories.PedidoRepository;
import com.janesouza.pizzacode.repositories.PizzaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final PizzaRepository pizzaRepository;
    private final BebidaRepository bebidaRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, PizzaRepository pizzaRepository, BebidaRepository bebidaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.pizzaRepository = pizzaRepository;
        this.bebidaRepository = bebidaRepository;
    }


    public Pedido criarPedido(Pedido pedido) {
        if (!validarPedido(pedido)) {
            throw new EntityNotFoundException("Um ou mais pedidos não foram encontrados.");
        }

        for (PizzaPedida pizzaPedida : pedido.getPizzaPedidos()) {
            pizzaPedida.setPedido(pedido);

        }
        pedidoRepository.save(pedido);
        return pedido;
    }

    public List<Pedido> exibirPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.isEmpty() ? Collections.emptyList() : pedidos;
    }

    public Pedido exibirPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado."));
    }

    public Pedido editarPedido(Long id, Pedido pedido) {
        Pedido pedidoDb = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado."));

        pedidoDb.setFornada(pedido.getFornada());
        pedidoDb.setPizzaPedidos(pedido.getPizzaPedidos());
        pedidoDb.setBebidaPedidos(pedido.getBebidaPedidos());

        return pedidoRepository.save(pedidoDb);
    }

    public boolean deletarPedido(Long id) {
        Pedido pedidoDb = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado."));
        pedidoRepository.delete(pedidoDb);
        return false;
    }

    public Pedido atualizarPedido(Long id, Pedido pedido) {
        return null;
    }
    public boolean validarPedido(Pedido pedido) {
        Cliente cliente = clienteRepository.findById(pedido.getIdCliente().getIdCliente())
                .orElse(null);
        if (cliente == null) {
            return false;
        }

        for (PizzaPedida pizzaPedida : pedido.getPizzaPedidos()) {
            Pizza pizza = pizzaPedida.getPizza();
            if (pizza == null || pizza.getIdPizza() == null) {
                return false;
            }
            Pizza pizzaDoBanco = pizzaRepository.findById(pizza.getIdPizza()).orElse(null);
            if (pizzaDoBanco == null) {
                return false;
            }
        }

        for (BebidaPedida bebidaPedida : pedido.getBebidaPedidos()) {
            Bebida bebida = bebidaPedida.getBebida();
            if (bebida == null || bebida.getIdBebida() == null) {
                return false;
            }
            Bebida bebidaDoBanco = bebidaRepository.findById(bebida.getIdBebida().longValue()).orElse(null);
            if (bebidaDoBanco == null) {
                return false;
            }
        }

        return true;
    }
}