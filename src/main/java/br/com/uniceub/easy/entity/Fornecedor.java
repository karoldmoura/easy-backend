package br.com.uniceub.easy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_fornecedor")
@Data
@EqualsAndHashCode(callSuper = true)
public class Fornecedor extends EntityAbstract<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor", nullable = false)
    private Long id;

    @Column(name = "ds_nome", nullable = false)
    private String nome;

    @Column(name = "ds_nome_fantasia", nullable = false)
    private String nomeFantasia;

    @Column(name = "nu_cnpj", nullable = false)
    private String cnpj;

    @Column(name = "ds_email", nullable = false)
    private String email;

    @Column(name = "ds_email_alternativo")
    private String emailAlternativo;

    @OneToMany(mappedBy = "fornecedor")
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;


}
