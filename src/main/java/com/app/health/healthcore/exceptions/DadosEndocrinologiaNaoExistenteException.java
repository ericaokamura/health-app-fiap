package com.app.health.healthcore.exceptions;

public class DadosEndocrinologiaNaoExistenteException extends RuntimeException {

    public DadosEndocrinologiaNaoExistenteException() {
    }

    public DadosEndocrinologiaNaoExistenteException(String message) {
        super(message);
    }

    public DadosEndocrinologiaNaoExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
