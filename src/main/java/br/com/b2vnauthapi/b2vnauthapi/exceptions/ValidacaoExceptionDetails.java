package br.com.b2vnauthapi.b2vnauthapi.exceptions;

import lombok.Data;

@Data
public class ValidacaoExceptionDetails {

    private long timestamp;
    private int status;
    private String error;
    private String message;

}
