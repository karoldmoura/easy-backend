package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long>, JpaSpecificationExecutor<Categoria> {

}