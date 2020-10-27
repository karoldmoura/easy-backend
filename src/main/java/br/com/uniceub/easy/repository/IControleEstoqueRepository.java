package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.ControleEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IControleEstoqueRepository extends JpaRepository<ControleEstoque, Long>, JpaSpecificationExecutor<ControleEstoque> {

}