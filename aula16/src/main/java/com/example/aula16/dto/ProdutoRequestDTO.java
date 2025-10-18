package com.example.aula16.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProdutoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String lote;

    private String validade;

    private String categoria;

    @Min(value = 0, message = "Quantidade não pode ser negativa")
    private int quantidade;
}
