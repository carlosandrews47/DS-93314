package org.example;

public class Endereco {
    private String logradouro;
    private int numero;
    private String cidade;

    // Construtor
    public Endereco(String logradouro, int numero, String cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
    }

    // Getters e Setters
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // Sobrescrevendo toString
    @Override
    public String toString() {
        return logradouro + ", " + numero + " - " + cidade;
    }

}
