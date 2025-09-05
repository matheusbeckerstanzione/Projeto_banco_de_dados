package br.com.ecommerce.api.controller;


import br.com.ecommerce.api.model.Produto;

import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
@RestController
@RequestMapping("//api/produto")
public class ProdutoController {

    // Controller depende do server
    private final ProdutoService produtoService;//3 passo

    public ProdutoController(ProdutoService service) {//4 passo
        produtoService = service;
    }
    //listar todos
    @GetMapping
    public ResponseEntity<List<Produto>> listarProduto(){//5 passo
        //1 pegar a lista de cliente
        List<Produto> produto = produtoService.ListarTodos();


        return ResponseEntity.ok(produto);
    }
}
