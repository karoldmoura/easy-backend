package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.SituacaoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ISituacaoPagamentoRepository
        extends JpaRepository<SituacaoPagamento, Integer>, JpaSpecificationExecutor<SituacaoPagamento> {

}