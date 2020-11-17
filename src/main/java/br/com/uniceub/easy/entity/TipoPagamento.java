package br.com.uniceub.easy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_tipo_pagamento")
@AllArgsConstructor
@NoArgsConstructor
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
