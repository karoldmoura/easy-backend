package br.com.uniceub.easy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_cliente")
public class Cliente extends EntityAbstract<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ds_uf", nullable = false)
    private Estado uf;

    @Column(name = "ds_nome", nullable = false)
    private String nome;

    @Column(name = "ds_endereco", nullable = false)
    private String endereco;

    @Column(name = "ds_bairro", nullable = false)
    private String bairro;

    @Column(name = "nu_cep", nullable = false)
    private Integer cep;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate nascimento;

    @Column(name = "ds_email", nullable = false)
    private String email;

    @Column(name = "ds_email_alternativo")
    private String emailAlternativo;

    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;

    @OneToMany(mappedBy = "cliente")
    private List<Telefone> telefones;

}
