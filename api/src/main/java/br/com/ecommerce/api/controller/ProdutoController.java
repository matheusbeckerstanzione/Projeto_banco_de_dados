package br.com.ecommerce.api.controller;


import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.model.Produto;

import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/produto")
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

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto){
        produtoService.cadastrarProduto(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @DeleteMapping
    public ResponseEntity<?> deletarProduto(@PathVariable Integer id){

        Produto produto = produtoService.deletarProduto(id);

        if(produto == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + "não encontrado");{}

        return ResponseEntity.ok(produto);
    }
}
