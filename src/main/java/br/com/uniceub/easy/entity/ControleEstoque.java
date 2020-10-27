package br.com.uniceub.easy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_controle_estoque")
public class ControleEstoque extends EntityAbstract<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_controle", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estoque", nullable = false)
    private Estoque estoque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venda")
    private Venda venda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_devolucao")
    private Devolucao devolucao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nu_matricula_retirada")
    private Usuario usuarioRetirada;

    @Column(name = "ds_retirada")
    private String motivoRetirada;

    @Column(name = "fl_retirada")
    private boolean retirada;

    @Column(name = "dt_saida", nullable = false)
    private LocalDateTime saida;

    @Column(name = "qt_produto", nullable = false)
    private Integer quantidade;

}
