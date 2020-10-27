package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.Estado;
import br.com.uniceub.easy.repository.IEstadoRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class EstadoService extends ServiceAbstract<Estado, IEstadoRepository> {

    @Autowired
    public EstadoService(IEstadoRepository repository){
        this.repository = repository;
    }
}
