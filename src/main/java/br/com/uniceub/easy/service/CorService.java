package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.Cor;
import br.com.uniceub.easy.repository.ICorRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CorService extends ServiceAbstract<Cor, ICorRepository> {

    @Autowired
    public CorService(ICorRepository repository){
        this.repository = repository;
    }
}
