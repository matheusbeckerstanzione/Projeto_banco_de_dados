package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.ProdutoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository r){
        produtoRepository = r;
    }

    public List<Produto> ListarTodos(){
        return produtoRepository.findAll();
    }

    public Produto cadastrarProduto(Produto pr){
        return produtoRepository.save(pr);
    }

    public Produto buscarPorId(Integer id){

        return produtoRepository.findById(id).orElse(null);

    }

    public Produto deletarProduto(Integer id){
        Produto produto = buscarPorId(id);

        if (produto != null){
            return null;
        }

        produtoRepository.deleteById(id);
        return produto;
    }
}
