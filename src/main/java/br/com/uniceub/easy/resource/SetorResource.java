package br.com.uniceub.easy.resource;

import br.com.uniceub.easy.dto.arquitetura.ResponseDTO;
import br.com.uniceub.easy.dto.base.SetorDTO;
import br.com.uniceub.easy.entity.Setor;
import br.com.uniceub.easy.service.SetorService;
import br.com.uniceub.easy.utils.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("setor")
public class SetorResource {

    @Autowired
    private SetorService service;

    @GetMapping
    public ResponseEntity<ResponseDTO> buscarTodos(){
        List<SetorDTO> lista = service.listar()
                .stream()
                .map(setor ->
                        ConverterUtil.converterToDTO(setor, SetorDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(
                new ResponseDTO(
                        ConverterUtil.converterToDTO(
                                service.buscarPorId(id),
                                SetorDTO.class
                        )
                )
        );
    }

    @GetMapping("paginacao")
    public ResponseEntity<ResponseDTO> paginacao(@PageableDefault Pageable pageable){
        Page<SetorDTO> lista = service.listar(pageable)
                .map(setor ->
                        ConverterUtil.converterToDTO(setor, SetorDTO.class, "produtos"));

        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> salvar(@RequestBody SetorDTO dto){
        SetorDTO setor = ConverterUtil.converterToDTO(
                service.salvar(ConverterUtil.converterToDTO(dto, Setor.class)),
                SetorDTO.class,
                "produtos"
        );

        return ResponseEntity.ok(new ResponseDTO());
    }

    @PatchMapping("{id}")
    public ResponseEntity<ResponseDTO> alterar(@PathVariable Long id, @RequestBody String descricao){
        service.editar(new Setor(id, descricao));
        return ResponseEntity.ok(new ResponseDTO());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseDTO> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.ok(new ResponseDTO());
    }
}
