package org.example;

/**
 * Camisa (herda Produto)
 */
public class Camisa extends Produto {
    public Camisa(String marca, String cor, String tamanho, double preco) {
        super(marca, cor, tamanho, preco);
    }

    @Override
    public String descricao() {
        return "Camisa: " + marca + " | Cor: " + cor + " | Tamanho: " + tamanho + " | Preço: R$ " + String.format("%.2f", preco);
    }

    @Override
    public String toString() { return descricao(); }
}
