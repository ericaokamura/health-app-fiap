package com.app.health.healthcore.exceptions;

public class GerenciamentoNaoExistenteException extends RuntimeException{

    public GerenciamentoNaoExistenteException() {
    }

    public GerenciamentoNaoExistenteException(String message) {
        super(message);
    }

    public GerenciamentoNaoExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
