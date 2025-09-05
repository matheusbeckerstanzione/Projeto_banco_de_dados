package br.com.ecommerce.api.controller;


import br.com.ecommerce.api.service.PedidoService;

import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
@RestController
@RequestMapping("//api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService service) {//4 passo
        pedidoService = service;




    }
}
