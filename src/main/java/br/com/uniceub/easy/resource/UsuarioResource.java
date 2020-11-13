package br.com.uniceub.easy.resource;

import br.com.uniceub.easy.dto.arquitetura.ResponseDTO;
import br.com.uniceub.easy.dto.base.UsuarioDTO;
import br.com.uniceub.easy.entity.Usuario;
import br.com.uniceub.easy.service.UsuarioService;
import br.com.uniceub.easy.utils.Converter;
import br.com.uniceub.easy.utils.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<ResponseDTO> salvar(@Valid @RequestBody UsuarioDTO dto){

        Usuario usuario = ConverterUtil.deepConvertToDTO(dto, Usuario.class);

        service.salvar(usuario);

        return ResponseEntity.ok(new ResponseDTO(null, "sucesso.salvo:Usuário"));
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseDTO> editar(@PathVariable(name = "id") Long id,
                                              @Valid @RequestBody UsuarioDTO dto){

        Usuario usuario = ConverterUtil.deepConvertToDTO(dto, Usuario.class);
        usuario.setId(id);

        service.editar(usuario);

        return ResponseEntity.ok(new ResponseDTO(null, "sucesso.salvo:Usuário"));
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<ResponseDTO> buscarPorId(Long id) {

        UsuarioDTO dto = Converter.usuarioToUsuarioDTO(service.buscarPorId(id));

        return ResponseEntity.ok(new ResponseDTO(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseDTO> excluir(@PathVariable(name = "id") Long id){

        service.excluir(id);

        return ResponseEntity.ok(new ResponseDTO());
    }

    @GetMapping("paginacao")
    @Transactional(readOnly = true)
    public ResponseEntity<ResponseDTO> listar(@PageableDefault Pageable pageable){

        Page<UsuarioDTO> pages = service.listar(pageable)
                .map(Converter::usuarioToUsuarioDTO);

        return ResponseEntity.ok(new ResponseDTO(pages));
    }

}
