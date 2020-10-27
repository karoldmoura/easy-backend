package br.com.uniceub.easy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_telefone")
@Data
@EqualsAndHashCode(callSuper = true)
public class Telefone extends EntityAbstract<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_telefone", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(columnDefinition = "nu_matricula", nullable = true)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(columnDefinition = "id_fornecedor", nullable = true)
    private Fornecedor fornecedor;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(columnDefinition = "id_cliente", nullable = true)
    private Cliente cliente;

    @Column(name = "ds_telefone", nullable = false)
    private String telefone;

    @Column(name = "fl_principal", nullable = false)
    private boolean principal;

}
