package br.com.uniceub.easy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_venda")
public class Venda extends EntityAbstract<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nu_matricula", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "id_tipo_pagamento", nullable = false)
    private TipoPagamento tipoPagamento;

    @Column(name = "vl_desconto")
    private BigDecimal desconto;

    @Column(name = "tx_desconto")
    private Integer taxaDesconto;

    @Column(name = "st_venda", nullable = false)
    private String situacao;

    @OneToMany(mappedBy = "venda")
    private List<ControleEstoque> controleEstoques;

    @OneToMany(mappedBy = "venda")
    private List<Devolucao> devolucoes;

}
