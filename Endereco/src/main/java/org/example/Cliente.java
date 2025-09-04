package org.example;

public class Cliente {
    private String nome;
    private int idade;
    private Endereco endereco; // relacionamento com Endereco

    // Construtor
    public Cliente(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    // Sobrescrevendo toString
    @Override
    public String toString() {
        return "Cliente: " + nome + "\nIdade: " + idade + "\nEndereço: " + endereco;
    }
}

