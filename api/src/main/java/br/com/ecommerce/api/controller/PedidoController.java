package br.com.ecommerce.api.controller;


import br.com.ecommerce.api.model.ItemPedido;
import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.PedidoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService service) {//4 passo
        pedidoService = service;

    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listResponseEntity(){
        List<Pedido> pedidos = pedidoService.listarTodos();

        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {

        pedidoService.cadastrarpedido(pedido);

        return ResponseEntity.ok(pedido);
    }


    @DeleteMapping
    public ResponseEntity<?> deletarPedido(@PathVariable Integer id){

        Pedido pedido = pedidoService.deletarPedido(id);

        if(pedido == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + "não encontrado");{}

        return ResponseEntity.ok(pedido);
    }
}
