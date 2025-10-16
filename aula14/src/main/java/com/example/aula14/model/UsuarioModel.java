package com.example.aula14.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tab_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "email", length = 150, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", length = 255, nullable = false)
    private String senha;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    // Construtor personalizado sem id
    public UsuarioModel(String nome, String email, String senha, Integer idade) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.ativo = true;
    }
}