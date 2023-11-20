package com.app.health.healthcore.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingControllerAdvice {

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<Void> usuarioNaoEncontradoException(){
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(DadosEndocrinologiaNaoExistenteException.class)
    public ResponseEntity<Void> dadoEndocrinologiaNaoExistenteException(){
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(GerenciamentoNaoExistenteException.class)
    public ResponseEntity<Void> gerenciamentoInsulinaNaoExistente(){
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(UsuarioJaExistenteException.class)
    public ResponseEntity<Void> usuarioJaExistenteException(){
        return ResponseEntity.badRequest().build();
    }


}
