package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.Categoria;
import br.com.uniceub.easy.repository.ICategoriaRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CategoriaService extends ServiceAbstract<Categoria, ICategoriaRepository> {

    @Autowired
    public CategoriaService(ICategoriaRepository repository ){
        this.repository = repository;
    }
}
