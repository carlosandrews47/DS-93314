package org.example;

import java.time.LocalDate;

/**
 * Classe abstrata que representa um funcionário da empresa
 * Define propriedades básicas e método abstrato para cálculo do salário final
 */
public abstract class Funcionario {
    private String nome;
    private String cpf;
    private String rg;
    private Genero genero;
    private Setor setor;
    private double salario;
    private LocalDate dataNascimento;
    private LocalDate dataAdmissao;

    // Construtor
    public Funcionario(String nome, String cpf, String rg, Genero genero, Setor setor,
                       double salario, LocalDate dataNascimento, LocalDate dataAdmissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.genero = genero;
        this.setor = setor;
        this.salario = salario;
        this.dataNascimento = dataNascimento;
        this.dataAdmissao = dataAdmissao;
    }

    // Método abstrato para cálculo do salário final
    public abstract double getSalarioFinal();

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", setor=" + setor +
                ", salario=" + salario +
                '}';
    }
}