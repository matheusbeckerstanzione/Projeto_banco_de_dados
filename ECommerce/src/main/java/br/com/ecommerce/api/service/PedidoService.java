package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.ItemPedido;
import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.PedidoRepository;
import br.com.ecommerce.api.repository.ProdutoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository r){
        pedidoRepository = r;
    }

    public List<Pedido> listarTodos(){
        return pedidoRepository.findAll();
    }
    public Pedido cadastrarpedido(Pedido pe){
        return pedidoRepository.save(pe);
    }



    public Pedido buscarPorId(Integer id){

        return pedidoRepository.findById(id).orElse(null);

    }

    public Pedido deletarPedido(Integer id){
        Pedido pedido = buscarPorId(id);

        if (pedido != null){
            return null;
        }

        pedidoRepository.deleteById(id);
        return pedido;
    }
}
