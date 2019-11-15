package br.com.b2vnauthapi.b2vnauthapi.exceptions.validacao;

import lombok.Data;

@Data
public class ValidacaoExceptionDetails {

    private long timestamp;
    private int status;
    private String error;
    private String message;

}
