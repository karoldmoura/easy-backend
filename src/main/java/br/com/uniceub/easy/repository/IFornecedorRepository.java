package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IFornecedorRepository extends JpaRepository<Fornecedor, Long>, JpaSpecificationExecutor<Fornecedor> {

}