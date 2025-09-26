package com.example.demo.model;


import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 200)
    private String logradouro;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column(nullable = false, length = 100)
    private String cidade;

    // Construtores
    public Aluno() {}

    public Aluno(String nome, String telefone, String email, String logradouro, String numero, String cidade) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // toString para facilitar a visualização
    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }

    // equals e hashCode baseados no ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return id != null && id.equals(aluno.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
