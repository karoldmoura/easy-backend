package br.com.uniceub.easy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_setor")
@AllArgsConstructor
@NoArgsConstructor
public class Setor extends EntityAbstract<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_setor", nullable = false)
    private Long id;

    @Column(name = "ds_setor", nullable = false)
    private String descricao;

}
