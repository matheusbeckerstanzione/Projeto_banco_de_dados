package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.ItemPedido;
import br.com.ecommerce.api.service.ItemPedidoService;
import br.com.ecommerce.api.service.PedidoService;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("//api/itemPedido")
public class ItemPedidoController {
    private final ItemPedidoService itempedidoService;

    public  ItemPedidoController(ItemPedidoService service) {
        itempedidoService = service;
    }

    @GetMapping
    public ResponseEntity<List<ItemPedido>> listar(){
        List<ItemPedido> itemPedidos = itempedidoService.ListarTudo();

        return ResponseEntity.ok(itemPedidos);
    }
}
