package org.example;

import java.time.LocalDate;

/**
 * Classe abstrata que representa um cargo de confiança na empresa
 * Estende Funcionario e adiciona propriedade de bonificação
 */
public abstract class CargoDeConfianca extends Funcionario {

    private Bonificacao bonificacao;

    // Construtor corrigido - adicionado parâmetro Setor

    public CargoDeConfianca(String nome, String cpf, String rg, Genero genero, Setor setor,
                            double salario, LocalDate dataNascimento, LocalDate dataAdmissao,
                            Bonificacao bonificacao) {
        // Chamada correta ao construtor da superclasse

        super(nome, cpf, rg, genero, setor, salario, dataNascimento, dataAdmissao);
        this.bonificacao = bonificacao;
    }

    public Bonificacao getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(Bonificacao bonificacao) {
        this.bonificacao = bonificacao;
    }
}