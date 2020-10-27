package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.TipoDevolucao;
import br.com.uniceub.easy.repository.ITipoDevolucaoRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class TipoDevolucaoService extends ServiceAbstract<TipoDevolucao, ITipoDevolucaoRepository> {

    @Autowired
    public TipoDevolucaoService(ITipoDevolucaoRepository repository){
        this.repository = repository;
    }
}
