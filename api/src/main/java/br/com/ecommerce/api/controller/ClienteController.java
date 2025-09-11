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

    //buscar cliente por id
    @GetMapping("/{id}")
    //pathVariable -> recebe um valor no link que aqui vai ser o id
    // request body -> recebe dados pelo corpo
    public ResponseEntity<?> buscarPorIdCliente(@PathVariable Integer id){
        //1. Procura o Cliente
        Cliente cliente = clienteService.buscarPorId(id);

        //2. se nao encontrar, retorne um erro
    if (cliente == null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + "não encontrado");
    }


        //3. Se encontrar, retorne cliente
        return ResponseEntity.ok(cliente);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente( @PathVariable Integer id){

        Cliente cliente = clienteService.deletarCliente(id);

        if (cliente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + "não encontrado");
        }
        return ResponseEntity.ok(cliente);
    }

    @PutMapping
    public ResponseEntity<?> atualizarCliente(@RequestBody Integer id, @RequestBody Cliente clienteNovo){

        Cliente cl = clienteService.atualizarCliente(id, clienteNovo);

        if (cl == null){
            return ResponseEntity.status(404).body("Cliente não encontrado");

        }
        return ResponseEntity.ok(cl);
    }

}
