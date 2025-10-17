
package com.example.aula15.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> illegalArgumentException(IllegalArgumentException erro) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of(
                        "mensagem", erro.getMessage(),
                        "success", false
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> methodArgumentNotValidException(MethodArgumentNotValidException erro) {
        String mensagem = erro.getFieldErrors().get(0).getDefaultMessage();
        return ResponseEntity
                .badRequest()
                .body(Map.of(
                        "mensagem", mensagem,
                        "success", false
                ));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> runtimeException(RuntimeException erro) {
        return ResponseEntity
                .badRequest()
                .body(Map.of(
                        "mensagem", erro.getMessage(),
                        "success", false
                ));
    }
}