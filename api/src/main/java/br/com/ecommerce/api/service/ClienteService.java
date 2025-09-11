package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.ItemPedido;
import br.com.ecommerce.api.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ClienteService {
    //injeção de dependencia
    //falar que Service depende de alguem
    //final constante
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository repo){
            clienteRepository = repo;

    }

    //listar
    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente cadastrarCliente(Cliente cl){
        return clienteRepository.save(cl);
    }

    public Cliente buscarPorId(Integer id){

        return clienteRepository.findById(id).orElse(null);

    }

    public Cliente deletarCliente(Integer id){

        Cliente cliente = buscarPorId(id);

        if (cliente == null){
           return null;
        }

        clienteRepository.delete(cliente);
        return cliente;
    }

    public Cliente atualizarCliente(Integer id, Cliente clienteNovo){

        Cliente clienteAntigo = buscarPorId(id);

        if (clienteAntigo == null){
            return null;
        }

        clienteAntigo.setNome(clienteNovo.getNome());
        clienteAntigo.setEmail(clienteNovo.getEmail());
        clienteAntigo.setDataCadastro(clienteNovo.getDataCadastro());
        clienteAntigo.setSenha(String.valueOf(clienteNovo.getSenha()));
        clienteAntigo.setTelefone(String.valueOf(clienteNovo.getTelefone()));


        return clienteRepository.save(clienteAntigo);
    }

}


