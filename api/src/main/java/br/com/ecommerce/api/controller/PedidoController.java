package br.com.ecommerce.api.controller;


import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.PedidoService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("//api/pedido")
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

}
