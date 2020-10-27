package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.Produto;
import br.com.uniceub.easy.repository.IProdutoRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ProdutoService extends ServiceAbstract<Produto, IProdutoRepository>{

    @Autowired
    public ProdutoService(IProdutoRepository repository){
        this.repository = repository;
    }
}
