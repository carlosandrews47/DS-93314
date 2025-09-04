package org.example.Clientepet;

public class Cliente {

    private String nome;
    private int idade;
    private Pet pet; // relacionamento com a classe Pet

    // Construtor
    public Cliente(String nome, int idade, Pet pet) {
        this.nome = nome;
        this.idade = idade;
        this.pet = pet;
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    // Sobrescrevendo toString()
    @Override
    public String toString() {
        return "Cliente: " + nome + "\nIdade: " + idade + "\n" + pet.toString();
    }
}

