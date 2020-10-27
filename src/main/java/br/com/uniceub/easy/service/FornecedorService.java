package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.Fornecedor;
import br.com.uniceub.easy.repository.IFornecedorRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class FornecedorService extends ServiceAbstract<Fornecedor, IFornecedorRepository> {

    @Autowired
    public FornecedorService(IFornecedorRepository repository){
        this.repository = repository;
    }
}
