package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity tratarErro400(MethodArgumentNotValidException exception){
//        var erros = exception.getFieldErrors();
//        List<ErrosFormatado> errosFormatados = erros.stream().map(ErrosFormatado::new).toList();
//
//        return ResponseEntity.badRequest().body();
//    }
//
//    private record DadosErroValidacao(String mensagem, String erro){
//        public DadosErroValidacao(Field ){
//            this()
//        }
//    }
}
