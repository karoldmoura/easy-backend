package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.TipoPagamento;
import br.com.uniceub.easy.repository.ITipoPagamentoRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class TipoPagamentoService extends ServiceAbstract<TipoPagamento, ITipoPagamentoRepository> {

    @Autowired
    public TipoPagamentoService(ITipoPagamentoRepository repository){
        this.repository = repository;
    }

}
