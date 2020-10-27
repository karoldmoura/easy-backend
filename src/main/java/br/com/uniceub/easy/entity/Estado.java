package br.com.uniceub.easy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_estado")
public class Estado extends EntityAbstract<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ds_uf", nullable = false)
    private String id;

    @Column(name = "ds_nome", nullable = false)
    private String nome;

}
