package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ISetorRepository extends JpaRepository<Setor, Long>, JpaSpecificationExecutor<Setor> {

}