package com.example.aula8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
            "success", false,
            "message", "Requisição inválida",
            "error", ex.getMessage(),
            "path", request.getDescription(false).replace("uri=", ""),
            "timestamp", System.currentTimeMillis(),
            "sugestao", "Verifique os dados enviados e tente novamente"
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> fieldErrors = new HashMap<>();
        
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            fieldErrors.put(fieldName, errorMessage);
        });
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
            "success", false,
            "message", "Erro de validação nos campos",
            "errors", fieldErrors,
            "total_erros", fieldErrors.size(),
            "path", request.getDescription(false).replace("uri=", ""),
            "timestamp", System.currentTimeMillis(),
            "sugestao", "Corrija os campos destacados e tente novamente"
        ));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
            "success", false,
            "message", "Erro interno no servidor",
            "error", ex.getMessage(),
            "path", request.getDescription(false).replace("uri=", ""),
            "timestamp", System.currentTimeMillis(),
            "sugestao", "Tente novamente em alguns instantes"
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
            "success", false,
            "message", "Erro interno no servidor",
            "path", request.getDescription(false).replace("uri=", ""),
            "timestamp", System.currentTimeMillis(),
            "sugestao", "Entre em contato com o suporte técnico"
        ));
    }
}