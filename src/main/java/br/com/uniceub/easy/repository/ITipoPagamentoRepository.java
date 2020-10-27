package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ITipoPagamentoRepository
        extends JpaRepository<TipoPagamento, Integer>, JpaSpecificationExecutor<TipoPagamento> {

}