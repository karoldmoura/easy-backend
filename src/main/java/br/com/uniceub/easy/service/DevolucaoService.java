package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.Devolucao;
import br.com.uniceub.easy.repository.IDevolucaoRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class DevolucaoService extends ServiceAbstract<Devolucao, IDevolucaoRepository> {

    @Autowired
    public DevolucaoService(IDevolucaoRepository repository){
        this.repository = repository;
    }
}
