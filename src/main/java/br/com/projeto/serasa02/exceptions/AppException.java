package br.com.projeto.serasa02.exceptions;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class AppException extends ResponseEntityExceptionHandler {

//    public ResponseEntity<?> handleScoreException(ScoreException ex){
//        Map<String, Object> body = new HashMap<>();
//    }
}
