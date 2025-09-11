package br.com.ecommerce.api.service;


import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.ItemPedido;
import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.repository.ItemPedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository  rep) {
        itemPedidoRepository = rep;
    }

    public List<ItemPedido> ListarTudo(){
        return itemPedidoRepository.findAll();
    }

    public ItemPedido cadastrarItemPedido(ItemPedido it){
        return itemPedidoRepository.save(it);


    }

    public ItemPedido buscarPorId(Integer id){

        return itemPedidoRepository.findById(id).orElse(null);

    }

    public ItemPedido deletarItemPedido(Integer id){
        ItemPedido itemPedido = buscarPorId(id);

        if (itemPedido != null){
            return null;
        }

        itemPedidoRepository.deleteById(id);
        return itemPedido;
    }
    }

