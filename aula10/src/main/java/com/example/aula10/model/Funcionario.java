package com.example.aula10.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Matrícula é obrigatória")
    private String matricula;

    private String dataNascimento;

    @Positive(message = "Salário deve ser positivo")
    private Double salario; // CORREÇÃO 3: Mudar para Double

    @Email(message = "Email deve ser válido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    @NotNull(message = "Endereço é obrigatório")
    private Endereco endereco; // CORREÇÃO 2: Certifique-se que Endereco está no package correto

    // Construtores
    public Funcionario() {}

    public Funcionario(String nome, String matricula, String dataNascimento, Double salario, String email, Endereco endereco) { // CORREÇÃO 3
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.email = email;
        this.endereco = endereco;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public Double getSalario() { return salario; } // CORREÇÃO 3
    public void setSalario(Double salario) { this.salario = salario; } // CORREÇÃO 3

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
}