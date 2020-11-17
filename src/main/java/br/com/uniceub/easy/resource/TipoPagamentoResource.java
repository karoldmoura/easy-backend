package br.com.uniceub.easy.resource;

import br.com.uniceub.easy.dto.arquitetura.ResponseDTO;
import br.com.uniceub.easy.dto.base.TipoPagamentoDTO;
import br.com.uniceub.easy.entity.TipoPagamento;
import br.com.uniceub.easy.service.TipoPagamentoService;
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
@RequestMapping("tipo-pagamento")
public class TipoPagamentoResource {

    @Autowired
    private TipoPagamentoService service;

    @GetMapping
    public ResponseEntity<ResponseDTO> buscarTodos(){
        List<TipoPagamentoDTO> lista = service.listar()
                .stream()
                .map(tipo ->
                        ConverterUtil.converterToDTO(tipo, TipoPagamentoDTO.class, "vendas"))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(
                new ResponseDTO(
                        ConverterUtil.converterToDTO(
                                service.buscarPorId(id),
                                TipoPagamentoDTO.class,
                                "vendas"
                        )
                )
        );
    }

    @GetMapping("paginacao")
    public ResponseEntity<ResponseDTO> paginacao(@PageableDefault Pageable pageable){
        Page<TipoPagamentoDTO> lista = service.listar(pageable)
                .map(tipo ->
                        ConverterUtil.converterToDTO(tipo, TipoPagamentoDTO.class, "vendas"));
        return ResponseEntity.ok(new ResponseDTO(lista));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> salvar(@RequestBody TipoPagamentoDTO dto){
        TipoPagamentoDTO tipoPagamento = ConverterUtil.converterToDTO(
                service.salvar(ConverterUtil.converterToDTO(dto, TipoPagamento.class)),
                TipoPagamentoDTO.class,
                "vendas"
        );

        return ResponseEntity.ok(new ResponseDTO(tipoPagamento));
    }

    @PatchMapping("{id}")
    public ResponseEntity<ResponseDTO> alterar(@PathVariable Long id, @RequestBody String descricao){
        service.editar(new TipoPagamento(id, descricao, null));
        return ResponseEntity.ok(new ResponseDTO());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseDTO> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.ok(new ResponseDTO());
    }
}
