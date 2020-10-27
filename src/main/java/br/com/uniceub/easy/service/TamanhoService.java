package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.Tamanho;
import br.com.uniceub.easy.repository.ITamanhoRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class TamanhoService extends ServiceAbstract<Tamanho, ITamanhoRepository> {

    @Autowired
    public TamanhoService(ITamanhoRepository repository){
        this.repository = repository;
    }
}
