package com.example.aula10.model;

import jakarta.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;
    private String logradouro;
    private String numero;
    private String cidade;

    @Enumerated(EnumType.STRING)
    private UnidadeFederativa uf;

    // Construtores
    public Endereco() {}

    public Endereco(String cep, String logradouro, String numero, String cidade, UnidadeFederativa uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public UnidadeFederativa getUf() { return uf; }
    public void setUf(UnidadeFederativa uf) { this.uf = uf; }
}