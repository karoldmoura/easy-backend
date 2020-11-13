package br.com.uniceub.easy.dto.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UsuarioDTO {

    private Long id;

    @NotBlank(message = "valid.naoinformado:Nome")
    private String nome;

    @NotBlank(message = "valid.naoinformado:E-mail")
    private String email;

    @NotBlank(message = "valid.naoinformado:Senha")
    private String senha;

    @NotBlank(message = "valid.naoinformado:CPF")
    private String cpf;

    private String tokenApp;

    @NotBlank(message = "valid.naoinformado:Login")
    private String login;

    @NotBlank(message = "valid.naoinformado:Sexo")
    private String sexo;

    @NotBlank(message = "valid.naoinformado:Nascimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate nascimento;

    @NotBlank(message = "valid.naoinformado:Endereço")
    private String endereco;

    @NotBlank(message = "valid.naoinformado:CEP")
    private String cep;

    @NotBlank(message = "valid.naoinformado:Bairro")
    private String bairro;

    @NotBlank(message = "valid.naoinformado:Setor")
    private SetorDTO setor;

    @NotBlank(message = "valid.naoinformado:UF")
    private EstadoDTO uf;

}
