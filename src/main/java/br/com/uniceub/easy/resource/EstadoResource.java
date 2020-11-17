package br.com.uniceub.easy.resource;

import br.com.uniceub.easy.dto.arquitetura.ResponseDTO;
import br.com.uniceub.easy.dto.base.EstadoDTO;
import br.com.uniceub.easy.service.EstadoService;
import br.com.uniceub.easy.utils.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("uf")
public class EstadoResource {

    @Autowired
    private EstadoService service;

    @GetMapping
    public ResponseEntity<ResponseDTO> buscarTodos(){
        List<EstadoDTO> lista = service.listar()
                .stream()
                .map(estado ->
                        ConverterUtil.converterToDTO(estado, EstadoDTO.class, "produtos"))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO> buscarPorId(@PathVariable String id){
        return ResponseEntity.ok(
                new ResponseDTO(ConverterUtil.converterToDTO(service.buscarPorId(id), EstadoDTO.class))
        );
    }

}
