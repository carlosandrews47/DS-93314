package org.example;

import java.time.LocalDate;

public class Diretor extends CargoDeConfianca {
    private static final double PREMIO = 0.2;

    public Diretor(String nome, String cpf, Genero genero, Setor setor, double salarioBase, LocalDate dataNascimento, LocalDate dataAdmissao) {
        super(nome, cpf, "", genero, salarioBase, dataNascimento, dataAdmissao, Bonificacao.DIRETOR);
        // "" usado para RG se não precisar
    }

    @Override
    public double getSalarioFinal() {
        return getSalarioBase() * (1 + PREMIO);
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", genero=" + getGenero() +
                ", salarioBase=" + getSalarioBase() +
                ", salarioFinal=" + getSalarioFinal() +
                '}';
    }
}