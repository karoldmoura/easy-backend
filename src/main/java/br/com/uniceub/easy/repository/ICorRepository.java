package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.Cor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICorRepository extends JpaRepository<Cor, String>, JpaSpecificationExecutor<Cor> {

}