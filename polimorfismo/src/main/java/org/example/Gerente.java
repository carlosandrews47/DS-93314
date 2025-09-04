package org.example;

import java.time.LocalDate;

public class Gerente extends CargoDeConfianca {

    // Construtor atualizado com parâmetro Setor
    public Gerente(String nome, String cpf, String rg, Genero genero, Setor setor,
                   double salarioBase, LocalDate dataNascimento, LocalDate dataAdmissao) {
        super(nome, cpf, rg, genero, setor, salarioBase, dataNascimento, dataAdmissao, Bonificacao.GERENTE);
    }

    @Override
    public double getSalarioFinal() {
        return getSalario() * (1 + getBonificacao().getValor());
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", setor=" + getSetor() +
                ", salarioBase=" + getSalario() +
                ", salarioFinal=" + getSalarioFinal() +
                '}';
    }
}