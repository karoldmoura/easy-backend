package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IVendaRepository extends JpaRepository<Venda, Integer>, JpaSpecificationExecutor<Venda> {

}