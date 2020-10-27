package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.Tamanho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ITamanhoRepository extends JpaRepository<Tamanho, String>, JpaSpecificationExecutor<Tamanho> {

}