package br.com.uniceub.easy.utils;

import br.com.uniceub.easy.dto.base.EstadoDTO;
import br.com.uniceub.easy.dto.base.SetorDTO;
import br.com.uniceub.easy.dto.base.UsuarioDTO;
import br.com.uniceub.easy.entity.Usuario;

public class Converter {
    public static UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
        UsuarioDTO dto = ConverterUtil.converterToDTO(usuario, UsuarioDTO.class, "senha");
        dto.setSetor(ConverterUtil.converterToDTO(usuario.getSetor(), SetorDTO.class));
        dto.setUf(ConverterUtil.converterToDTO(usuario.getUf(), EstadoDTO.class));
        return dto;
    }
}
