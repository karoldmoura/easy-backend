package br.com.uniceub.easy.exception;

import br.com.uniceub.easy.dto.arquitetura.ResponseDTO;
import br.com.uniceub.easy.utils.MessageUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EasyException extends RuntimeException {

    private HttpStatus status;

    public EasyException(){
        super("Ocorreu um erro.");
    }

    public EasyException(String message){
        super(message);
    }

    public EasyException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public ResponseEntity<ResponseDTO> getResponseDTO() {
        return ResponseEntity.status(status != null ? status : HttpStatus.BAD_REQUEST).body(
                new ResponseDTO(null, MessageUtil.tratarMensagem(this.getMessage()))
        );
    }
}
