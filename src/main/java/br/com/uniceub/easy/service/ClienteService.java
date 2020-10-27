package br.com.uniceub.easy.service;

import br.com.uniceub.easy.entity.Cliente;
import br.com.uniceub.easy.repository.IClienteRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ClienteService extends ServiceAbstract<Cliente, IClienteRepository> {

    @Autowired
    public ClienteService (IClienteRepository repository){
        this.repository = repository;
    }
}
