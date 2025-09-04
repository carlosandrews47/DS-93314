package org.example;

import java.time.LocalDate;

public abstract class Funcionario {
    private String nome;
    private String cpf;
    private String rg;
    private Genero genero;
    private Setor setor;
    private double salarioBase;
    private LocalDate dataNascimento;
    private LocalDate dataAdmissao;

    public Funcionario(String nome, String cpf, String rg, Genero genero, Setor setor,
                       double salarioBase, LocalDate dataNascimento, LocalDate dataAdmissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.genero = genero;
        this.setor = setor;
        this.salarioBase = salarioBase;
        this.dataNascimento = dataNascimento;
        this.dataAdmissao = dataAdmissao;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getRg() { return rg; }
    public Genero getGenero() { return genero; }
    public Setor getSetor() { return setor; }
    public double getSalarioBase() { return salarioBase; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public LocalDate getDataAdmissao() { return dataAdmissao; }

    public abstract double getSalarioFinal();

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", genero=" + genero +
                ", setor=" + setor +
                ", salarioBase=" + salarioBase +
                ", dataNascimento=" + dataNascimento +
                ", dataAdmissao=" + dataAdmissao +
                '}';
    }
}