package br.com.uniceub.easy.resource;

import br.com.uniceub.easy.dto.base.CategoriaDTO;
import br.com.uniceub.easy.dto.arquitetura.ResponseDTO;
import br.com.uniceub.easy.entity.Categoria;
import br.com.uniceub.easy.service.CategoriaService;
import br.com.uniceub.easy.utils.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<ResponseDTO> buscarTodos(){
        List<CategoriaDTO> lista = service.listar()
                .stream()
                .map(categoria ->
                        ConverterUtil.converterToDTO(categoria, CategoriaDTO.class, "produtos"))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO> buscarPorId(@RequestParam Long id){
        return ResponseEntity.ok(
                new ResponseDTO(
                        ConverterUtil.converterToDTO(
                                service.buscarPorId(id),
                                CategoriaDTO.class,
                                "produtos"
                        )
                )
        );
    }

    @GetMapping("paginacao")
    public ResponseEntity<ResponseDTO> paginacao(@PageableDefault Pageable pageable){
        List<CategoriaDTO> lista = service.listar(pageable)
                .stream()
                .map(categoria ->
                        ConverterUtil.converterToDTO(categoria, CategoriaDTO.class, "produtos"))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> salvar(@RequestBody CategoriaDTO dto){
        service.salvar(ConverterUtil.converterToDTO(dto, Categoria.class));

        return ResponseEntity.ok(new ResponseDTO());
    }

    @PatchMapping("{id}")
    public ResponseEntity<ResponseDTO> alterar(@RequestParam Long id, @RequestBody String descricao){
        service.editar(new Categoria(id, descricao, null));
        return ResponseEntity.ok(new ResponseDTO());
    }
}
