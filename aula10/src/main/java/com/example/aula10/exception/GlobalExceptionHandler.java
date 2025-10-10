package com.example.aula10.exception;

import com.example.aula10.dto.RespostaApi;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RespostaApi> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        RespostaApi resposta = new RespostaApi(false, "Dados de entrada inválidos", errors);
        return ResponseEntity.badRequest().body(resposta);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespostaApi> handleGeneralException(Exception ex) {
        RespostaApi resposta = new RespostaApi(false, "Erro interno do servidor: " + ex.getMessage());
        return ResponseEntity.internalServerError().body(resposta);
    }
}


