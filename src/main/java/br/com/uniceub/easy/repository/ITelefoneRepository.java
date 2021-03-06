package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ITelefoneRepository
        extends JpaRepository<Telefone, Integer>, JpaSpecificationExecutor<Telefone> {

}