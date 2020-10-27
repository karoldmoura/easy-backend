package br.com.uniceub.easy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_situacao_pagamento")
public class SituacaoPagamento extends EntityAbstract<Long>{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_venda", nullable = false)
    private Long id;

    @Column(name = "dt_pendente", nullable = false)
    private LocalDateTime pendente;

    @Column(name = "dt_analise")
    private LocalDateTime analise;

    @Column(name = "dt_aprovado")
    private LocalDateTime aprovado;

    @Column(name = "dt_cancelado")
    private LocalDateTime cancelado;

    @Column(name = "dt_devolvido")
    private LocalDateTime devolvido;

}
