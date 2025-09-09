package br.com.ecommerce.api.controller;


import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService service) {
        pagamentoService = service;
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>> listPagamento(){
        List<Pagamento> pagamentos = pagamentoService.ListarTudo();

        return ResponseEntity.ok(pagamentos);
    }

    @PostMapping
    public ResponseEntity<Pagamento> cadastrarPagamento(@RequestBody Pagamento pg){
        pagamentoService.cadastrarPagamento(pg);

        return ResponseEntity.status(HttpStatus.CREATED).body(pg);
    }
}
