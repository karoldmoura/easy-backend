package br.com.uniceub.easy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_tamanho")
@Data
@EqualsAndHashCode(callSuper = true)
public class Tamanho extends EntityAbstract<String>{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ds_tamanho", nullable = false)
    private String id;

    @OneToMany(mappedBy = "tamanho")
    private List<Estoque> estoques;

}
