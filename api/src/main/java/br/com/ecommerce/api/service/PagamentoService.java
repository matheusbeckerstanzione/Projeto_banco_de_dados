package br.com.ecommerce.api.service;


import br.com.ecommerce.api.model.ItemPedido;
import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.repository.ClienteRepository;
import br.com.ecommerce.api.repository.PagamentoRepository;
import br.com.ecommerce.api.repository.PedidoRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    public PagamentoService(PagamentoRepository r) {
        pagamentoRepository = r;
    }

    public List<Pagamento> ListarTudo(){
        return pagamentoRepository.findAll();
    }

    public Pagamento cadastrarPagamento(Pagamento pg){
        return pagamentoRepository.save(pg);
    }


    public Pagamento buscarPorId(Integer id){

        return pagamentoRepository.findById(id).orElse(null);

    }

    public Pagamento deletarPagamento(Integer id){
        Pagamento pagamento = buscarPorId(id);

        if (pagamento != null){
            return null;
        }


        pagamentoRepository.deleteById(id);
        return pagamento;
    }
}

