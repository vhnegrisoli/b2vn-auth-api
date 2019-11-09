package br.com.b2vnauthapi.b2vnauthapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ValidacaoException extends RuntimeException {

    public ValidacaoException(String message) {
        super(message);
    }
}
