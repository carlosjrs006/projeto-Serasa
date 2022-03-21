package br.com.projeto.serasa02.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class RecursoNaoEncontradoException extends RuntimeException {
    public RecursoNaoEncontradoException(String exception) {
        super(exception);
    }
}
