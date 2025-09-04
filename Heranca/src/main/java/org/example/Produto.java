package org.example;

/**
 * <<abstract>> Produto
 * - modelo base para Camisa, Calca, Sapato
 * - atributos comuns: marca, cor, tamanho, preco
 */
public abstract class Produto {
    protected String marca;
    protected String cor;
    protected String tamanho;
    protected double preco;

    public Produto(String marca, String cor, String tamanho, double preco) {
        this.marca = marca;
        this.cor = cor;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public String getMarca() { return marca; }
    public String getCor() { return cor; }
    public String getTamanho() { return tamanho; }
    public double getPreco() { return preco; }

    public abstract String descricao();
}
