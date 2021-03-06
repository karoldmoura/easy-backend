package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.Setor;
import br.com.uniceub.easy.repository.ISetorRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class SetorService extends ServiceAbstract<Setor, ISetorRepository> {

    @Autowired
    public SetorService(ISetorRepository repository){
        this.repository = repository;
    }
}
