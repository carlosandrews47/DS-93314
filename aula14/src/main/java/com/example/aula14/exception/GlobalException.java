package com.example.aula14.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    // Padronizando mensagem de exceção do Service.
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> illegalArgumentException(IllegalArgumentException error) {
        return ResponseEntity
                .badRequest()
                .body(Map.of("mensagem", error.getMessage()));
    }

    // Padronizando mensagem de exceção do web interface do RequestDTO.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> methodArgumentNotValidException(MethodArgumentNotValidException error) {
        return ResponseEntity
                .badRequest()
                .body(Map.of("mensagem", error.getFieldErrors().get(0).getDefaultMessage()));
    }
}