package org.example;

import java.time.LocalDate;

// Certifique-se de que Funcionario existe e está compilando
public abstract class CargoDeConfianca extends Funcionario {
    private Bonificacao bonificacao;

    public CargoDeConfianca(String nome, String cpf, String rg, Genero genero,
                            double salarioBase, LocalDate dataNascimento, LocalDate dataAdmissao,
                            Bonificacao bonificacao) {
        super(nome, cpf, rg, genero, salarioBase, dataNascimento, dataAdmissao);
        this.bonificacao = bonificacao;
    }

    public Bonificacao getBonificacao() {
        return bonificacao;
    }

    @Override
    public abstract double getSalarioFinal();
}