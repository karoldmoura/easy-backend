package br.com.uniceub.easy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_tipo_devolucao")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TipoDevolucao extends EntityAbstract<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo", nullable = false)
    private Long id;

    @Column(name = "ds_tipo", nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "tipo")
    private List<Devolucao> devolucoes;

}
