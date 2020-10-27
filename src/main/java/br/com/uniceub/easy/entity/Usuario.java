package br.com.uniceub.easy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
@Data
@EqualsAndHashCode(callSuper = true)
public class Usuario extends EntityAbstract<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nu_matricula", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "id_setor")
    private Setor setor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "ds_uf")
    private Estado uf;

    @Column(name = "ds_nome", nullable = false)
    private String nome;

    @Column(name = "nu_cpf", nullable = false)
    private BigInteger cpf;

    @Column(name = "ds_email", nullable = false)
    private String email;

    @Column(name = "ds_endereco", nullable = false)
    private String endereco;

    @Column(name = "nu_cep", nullable = false)
    private String cep;

    @Column(name = "ds_bairro", nullable = false)
    private String bairro;

    @Column(name = "dt_nascimento", nullable = false)
    private Date nascimento;

    @Column(name = "fl_sexo", nullable = false)
    private String sexo;

    @Column(name = "ds_login", nullable = false)
    private String login;

    @Column(name = "ds_senha")
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Venda> vendas;

    @OneToMany(mappedBy = "usuario")
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "usuarioRetirada")
    private List<ControleEstoque> controleEstoques;

}
