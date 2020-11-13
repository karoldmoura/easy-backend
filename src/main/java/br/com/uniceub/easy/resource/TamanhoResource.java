package br.com.uniceub.easy.resource;

import br.com.uniceub.easy.dto.base.CorDTO;
import br.com.uniceub.easy.dto.base.TamanhoDTO;
import br.com.uniceub.easy.dto.arquitetura.ResponseDTO;
import br.com.uniceub.easy.entity.Tamanho;
import br.com.uniceub.easy.service.TamanhoService;
import br.com.uniceub.easy.utils.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tamanho")
public class TamanhoResource {

    @Autowired
    private TamanhoService service;

    @GetMapping
    public ResponseEntity<ResponseDTO> buscarTodos(){
        List<TamanhoDTO> lista = service.listar()
                .stream()
                .map(tamanho ->
                        ConverterUtil.converterToDTO(tamanho, TamanhoDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO> buscarPorId(@RequestParam Long id){
        return ResponseEntity.ok(
                new ResponseDTO(
                        ConverterUtil.converterToDTO(
                                service.buscarPorId(id),
                                CorDTO.class
                        )
                )
        );
    }

    @GetMapping("paginacao")
    public ResponseEntity<ResponseDTO> paginacao(@PageableDefault Pageable pageable){
        List<TamanhoDTO> lista = service.listar(pageable)
                .stream()
                .map(tamanho ->
                        ConverterUtil.converterToDTO(tamanho, TamanhoDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> salvar(@RequestBody TamanhoDTO dto){
        service.salvar(ConverterUtil.converterToDTO(dto, Tamanho.class));

        return ResponseEntity.ok(new ResponseDTO());
    }

}
