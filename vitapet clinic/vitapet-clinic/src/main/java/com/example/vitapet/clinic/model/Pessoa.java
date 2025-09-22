package com.example.vitapet.clinic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe base para pessoas (não gera tabela própria).
 */
@MappedSuperclass
@Getter
@Setter
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    @Column(unique = true)
    private String cpf;

    @Email(message = "Email deve ser válido")
    private String email;

    private String telefone;

    @Embedded
    private Endereco endereco;  // Classe Endereco precisa existir com @Embeddable
}