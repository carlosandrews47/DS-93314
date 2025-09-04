package org.example;

public enum Setor {

    RECURSOS_HUMANOS("RH"),
    FINANCEIRO("Financeiro"),
    OPERACOES("Operações");

    private final String nome;

    Setor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
