package br.com.uniceub.easy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_produto")
public class Produto extends EntityAbstract<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor fornecedor;

    @Column(name = "ds_produto", nullable = false)
    private String descricao;

    @Column(name = "dt_inclusao", nullable = false)
    private LocalDateTime inclusao;

    @OneToMany(mappedBy = "produto")
    private List<Devolucao> devolucoes;

    @OneToMany(mappedBy = "produto")
    private List<Estoque> estoques;

}
