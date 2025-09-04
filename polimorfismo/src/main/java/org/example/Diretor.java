package org.example;

import java.time.LocalDate;

public class Diretor extends CargoDeConfianca {

    private static final double PREMIO = 0.2;

    // Construtor atualizado com parâmetro Setor
    public Diretor(String nome, String cpf, String rg, Genero genero, Setor setor,
                   double salarioBase, LocalDate dataNascimento, LocalDate dataAdmissao) {
        super(nome, cpf, rg, genero, setor, salarioBase, dataNascimento, dataAdmissao, Bonificacao.DIRETOR);
    }

    @Override
    public double getSalarioFinal() {
        return getSalario() * (1 + getBonificacao().getValor() + PREMIO);
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", genero=" + getGenero() +
                ", setor=" + getSetor() +
                ", salarioBase=" + getSalario() +
                ", salarioFinal=" + getSalarioFinal() +
                '}';
    }
}