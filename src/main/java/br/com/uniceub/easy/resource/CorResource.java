package br.com.uniceub.easy.resource;

import br.com.uniceub.easy.dto.arquitetura.ResponseDTO;
import br.com.uniceub.easy.dto.base.CorDTO;
import br.com.uniceub.easy.entity.Cor;
import br.com.uniceub.easy.service.CorService;
import br.com.uniceub.easy.utils.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cor")
public class CorResource {

    @Autowired
    private CorService service;

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<ResponseDTO> buscarTodos(){
        List<CorDTO> lista = service.listar()
                .stream()
                .map(cor ->
                        ConverterUtil.converterToDTO(cor, CorDTO.class, "produtos"))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @GetMapping("{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<ResponseDTO> buscarPorId(@PathVariable String id){
        return ResponseEntity.ok(
                new ResponseDTO(
                        ConverterUtil.converterToDTO(
                                service.buscarPorId(id),
                                CorDTO.class,
                                "estoques"
                        )
                )
        );
    }

    @GetMapping("paginacao")
    @Transactional(readOnly = true)
    public ResponseEntity<ResponseDTO> paginacao(@PageableDefault Pageable pageable){
        Page<CorDTO> lista = service.listar(pageable)
                .map(cor -> ConverterUtil.converterToDTO(cor, CorDTO.class, "estoques"));

        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> salvar(@RequestBody CorDTO dto){
        CorDTO corDTO = ConverterUtil.converterToDTO(
                service.salvar(ConverterUtil.converterToDTO(dto, Cor.class)),
                CorDTO.class,
                "estoques"
        );

        return ResponseEntity.ok(new ResponseDTO());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseDTO> excluir(@PathVariable String id){
        service.excluir(id);

        return ResponseEntity.ok(new ResponseDTO());
    }
}
