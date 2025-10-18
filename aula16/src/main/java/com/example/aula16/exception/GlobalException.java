package com.example.aula16.exception;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class GlobalException extends RuntimeException {

    private final LocalDateTime timestamp;
    private final String errorCode;
    private final String details;

    // Construtor básico
    public GlobalException(String message) {
        super(message);
        this.timestamp = LocalDateTime.now();
        this.errorCode = "GENERIC_ERROR";
        this.details = null;
    }

    // Construtor com código de erro
    public GlobalException(String message, String errorCode) {
        super(message);
        this.timestamp = LocalDateTime.now();
        this.errorCode = errorCode;
        this.details = null;
    }

    // Construtor completo
    public GlobalException(String message, String errorCode, String details) {
        super(message);
        this.timestamp = LocalDateTime.now();
        this.errorCode = errorCode;
        this.details = details;
    }

    // Métodos estáticos para criar exceções específicas
    public static GlobalException notFound(String resourceName, Long id) {
        String message = String.format("%s com ID %d não encontrado", resourceName, id);
        return new GlobalException(message, "RESOURCE_NOT_FOUND");
    }

    public static GlobalException notFound(String resourceName) {
        String message = String.format("%s não encontrado", resourceName);
        return new GlobalException(message, "RESOURCE_NOT_FOUND");
    }

    public static GlobalException validationError(String field, String issue) {
        String message = String.format("Erro de validação no campo '%s': %s", field, issue);
        return new GlobalException(message, "VALIDATION_ERROR", field);
    }

    public static GlobalException alreadyExists(String resourceName, String identifier) {
        String message = String.format("%s com identificador '%s' já existe", resourceName, identifier);
        return new GlobalException(message, "RESOURCE_ALREADY_EXISTS");
    }

    // Método para logar informações da exceção
    public String getFullErrorInfo() {
        return String.format(
                "[%s] Code: %s - Message: %s - Details: %s",
                timestamp, errorCode, getMessage(), details != null ? details : "N/A"
        );
    }

    @Override
    public String toString() {
        return String.format(
                "GlobalException{timestamp=%s, errorCode='%s', message='%s', details='%s'}",
                timestamp, errorCode, getMessage(), details
        );
    }
}
