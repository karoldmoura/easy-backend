package br.com.uniceub.easy.repository;

import br.com.uniceub.easy.entity.TipoDevolucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ITipoDevolucaoRepository
        extends JpaRepository<TipoDevolucao, Integer>, JpaSpecificationExecutor<TipoDevolucao> {

}