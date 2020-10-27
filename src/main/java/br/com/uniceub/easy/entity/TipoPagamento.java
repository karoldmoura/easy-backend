package br.com.uniceub.easy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_tipo_pagamento")
public class TipoPagamento extends EntityAbstract<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_pagamento", nullable = false)
    private Long id;

    @Column(name = "ds_tipo_pagamento", nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "tipoPagamento")
    private List<Venda> vendas;

}
