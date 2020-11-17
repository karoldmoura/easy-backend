package br.com.uniceub.easy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_devolucao")
@Data
@EqualsAndHashCode(callSuper = true)
public class Devolucao extends EntityAbstract<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devolucao", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venda", nullable = false)
    private Venda venda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo", nullable = false)
    private TipoDevolucao tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @Column(name = "qt_produto", nullable = false)
    private Integer quantidade;

    @Column(name = "dt_devolucao", nullable = false)
    private LocalDateTime data;

    @OneToMany(mappedBy = "devolucao")
    private List<ControleEstoque> controleEstoques;
}
