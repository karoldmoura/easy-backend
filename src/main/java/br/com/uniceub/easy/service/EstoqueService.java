package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.Estoque;
import br.com.uniceub.easy.repository.IEstoqueRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class EstoqueService extends ServiceAbstract<Estoque, IEstoqueRepository> {

    @Autowired
    public EstoqueService(IEstoqueRepository repository){
        this.repository = repository;
    }
}
