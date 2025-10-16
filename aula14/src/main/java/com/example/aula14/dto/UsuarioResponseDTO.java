package com.example.aula14.dto;

public class UsuarioResponseDTO {
    private String nome;
    private String email;

    // Construtor VAZIO (obrigatório)
    public UsuarioResponseDTO() {}

    // Construtor com nome e email
    public UsuarioResponseDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}