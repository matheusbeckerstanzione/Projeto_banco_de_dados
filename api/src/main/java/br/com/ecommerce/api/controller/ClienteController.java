package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //primeiro passo

@RequestMapping("/api/clientes") //segundo passo


public class ClienteController {
    // Controller depende do server
    private final ClienteService clienteService;//3 passo

    public ClienteController(ClienteService service) {//4 passo
      clienteService = service;
    }
     //listar todos
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){//5 passo
        //1 pegar a lista de cliente
        List<Cliente> clientes = clienteService.listarTodos();


        return ResponseEntity.ok(clientes);
    }

   @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){

       clienteService.cadastrarCliente(cliente);

       return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
   }
}
