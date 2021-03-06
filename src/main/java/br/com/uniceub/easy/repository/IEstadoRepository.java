package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, String>, JpaSpecificationExecutor<Estado> {

}