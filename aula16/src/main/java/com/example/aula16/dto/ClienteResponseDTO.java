package com.example.aula16.dto;

import lombok.Data;

@Data
public class ClienteResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String formalPagamento;
    private String endereco;
}
