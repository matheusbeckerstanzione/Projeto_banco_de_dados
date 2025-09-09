package br.com.ecommerce.api.service;


import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.repository.ClienteRepository;
import br.com.ecommerce.api.repository.PagamentoRepository;
import br.com.ecommerce.api.repository.PedidoRepository;
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
}
