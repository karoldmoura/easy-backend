package br.com.uniceub.easy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_estoque")
public class Estoque extends EntityAbstract<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estoque", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ds_tamanho", nullable = false)
    private Tamanho tamanho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ds_cor", nullable = false)
    private Cor cor;

    @Column(name = "vl_preco_custo", nullable = false)
    private BigDecimal precoCusto;

    @Column(name = "vl_preco_venda", nullable = false)
    private BigDecimal precoVenda;

    @Column(name = "tx_lucro", nullable = false)
    private BigDecimal taxaLucro;

    @Column(name = "dt_entrada", nullable = false)
    private LocalDateTime entrada;

    @OneToMany(mappedBy = "estoque")
    private List<ControleEstoque> controleEstoques;

}
