package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ITelefoneRepository
        extends JpaRepository<Telefone, Integer>, JpaSpecificationExecutor<Telefone> {

}