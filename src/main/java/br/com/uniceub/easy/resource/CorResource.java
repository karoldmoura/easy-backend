package br.com.uniceub.easy.resource;

import br.com.uniceub.easy.dto.base.CorDTO;
import br.com.uniceub.easy.dto.arquitetura.ResponseDTO;
import br.com.uniceub.easy.entity.Cor;
import br.com.uniceub.easy.service.CorService;
import br.com.uniceub.easy.utils.ConverterUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cor")
public class CorResource {

    private CorService service;

    @GetMapping
    public ResponseEntity<ResponseDTO> buscarTodos(){
        List<CorDTO> lista = service.listar()
                .stream()
                .map(cor ->
                        ConverterUtil.converterToDTO(cor, CorDTO.class, "produtos"))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO> buscarPorId(@RequestParam Long id){
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
    public ResponseEntity<ResponseDTO> paginacao(@PageableDefault Pageable pageable){
        List<CorDTO> lista = service.listar(pageable)
                .stream()
                .map(cor ->
                        ConverterUtil.converterToDTO(cor, CorDTO.class, "estoques"))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> salvar(@RequestBody CorDTO dto){
        service.salvar(ConverterUtil.converterToDTO(dto, Cor.class));

        return ResponseEntity.ok(new ResponseDTO());
    }
}
