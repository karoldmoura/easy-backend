package br.com.uniceub.easy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_cor")
public class Cor extends EntityAbstract<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ds_cor", nullable = false)
    private String id;

    @OneToMany(mappedBy = "cor")
    private List<Estoque> estoques;

}
