package com.example.aula16.dto;

import lombok.Data;

@Data
public class ProdutoResponseDTO {
    private Long id;
    private String nome;
    private String lote;
    private String validade;
    private String categoria;
    private int quantidade;
}
