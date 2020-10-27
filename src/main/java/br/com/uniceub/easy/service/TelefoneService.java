package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.Telefone;
import br.com.uniceub.easy.repository.ITelefoneRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class TelefoneService extends ServiceAbstract<Telefone, ITelefoneRepository> {

    @Autowired
    public TelefoneService(ITelefoneRepository repository){
        this.repository = repository;
    }
}
