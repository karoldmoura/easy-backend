package br.com.uniceub.easy.resource;

import br.com.uniceub.easy.dto.arquitetura.ResponseDTO;
import br.com.uniceub.easy.dto.base.TipoDevolucaoDTO;
import br.com.uniceub.easy.entity.TipoDevolucao;
import br.com.uniceub.easy.service.TipoDevolucaoService;
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
@RequestMapping("tipo-devolucao")
public class TipoDevolucaoResource {

    @Autowired
    private TipoDevolucaoService service;

    @GetMapping
    public ResponseEntity<ResponseDTO> buscarTodos(){
        List<TipoDevolucaoDTO> lista = service.listar()
                .stream()
                .map(tipo ->
                        ConverterUtil.converterToDTO(tipo, TipoDevolucaoDTO.class, "devolucoes"))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(
                new ResponseDTO(
                        ConverterUtil.converterToDTO(
                                service.buscarPorId(id),
                                TipoDevolucaoDTO.class,
                                "devolucoes"
                        )
                )
        );
    }

    @GetMapping("paginacao")
    public ResponseEntity<ResponseDTO> paginacao(@PageableDefault Pageable pageable){
        Page<TipoDevolucaoDTO> lista = service.listar(pageable)
                .map(tipo ->
                        ConverterUtil.converterToDTO(tipo, TipoDevolucaoDTO.class, "devolucoes"));

        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> salvar(@RequestBody TipoDevolucaoDTO dto){
        TipoDevolucaoDTO tipoDevolucao = ConverterUtil.converterToDTO(
                service.salvar(ConverterUtil.converterToDTO(dto, TipoDevolucao.class)),
                TipoDevolucaoDTO.class,
                "devolucoes"
        );

        return ResponseEntity.ok(new ResponseDTO(tipoDevolucao));
    }

    @PatchMapping("{id}")
    public ResponseEntity<ResponseDTO> alterar(@PathVariable Long id, @RequestBody String descricao){
        service.editar(new TipoDevolucao(id, descricao, null));
        return ResponseEntity.ok(new ResponseDTO());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseDTO> excluir(@PathVariable Long id){
        service.excluir(id);

        return ResponseEntity.ok(new ResponseDTO());
    }
}
