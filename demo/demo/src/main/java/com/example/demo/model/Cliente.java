package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(nullable = false, unique = true, length = 20)
    private String protocoloAtendimento;

    // Construtores
    public Cliente() {}

    public Cliente(String nome, LocalDate dataNascimento, String protocoloAtendimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.protocoloAtendimento = protocoloAtendimento;
    }

    // Getters e Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getProtocoloAtendimento() { return protocoloAtendimento; }
    public void setProtocoloAtendimento(String protocoloAtendimento) { this.protocoloAtendimento = protocoloAtendimento; }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", protocoloAtendimento='" + protocoloAtendimento + '\'' +
                '}';
    }
}