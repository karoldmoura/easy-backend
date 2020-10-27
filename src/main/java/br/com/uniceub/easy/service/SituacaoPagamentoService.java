package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.SituacaoPagamento;
import br.com.uniceub.easy.repository.ISituacaoPagamentoRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class SituacaoPagamentoService extends ServiceAbstract<SituacaoPagamento, ISituacaoPagamentoRepository> {

    @Autowired
    public SituacaoPagamentoService (ISituacaoPagamentoRepository repository){
        this.repository = repository;
    }
}
