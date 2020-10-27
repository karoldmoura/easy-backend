package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.ControleEstoque;
import br.com.uniceub.easy.repository.IControleEstoqueRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ControleEstoqueService extends ServiceAbstract<ControleEstoque, IControleEstoqueRepository> {

    @Autowired
    public ControleEstoqueService (IControleEstoqueRepository repository){
        this.repository = repository;
    }
}
