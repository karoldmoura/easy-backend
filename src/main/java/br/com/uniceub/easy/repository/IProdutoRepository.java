package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IProdutoRepository
        extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {

}