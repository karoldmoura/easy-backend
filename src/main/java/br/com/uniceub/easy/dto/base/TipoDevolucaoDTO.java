package br.com.uniceub.easy.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoDevolucaoDTO {

    private Long id;

    private String descricao;
}
