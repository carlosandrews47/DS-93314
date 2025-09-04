package org.example;

/**
 * Calça (herda Produto)
 */
public class Calca extends Produto {
    public Calca(String marca, String cor, String tamanho, double preco) {
        super(marca, cor, tamanho, preco);
    }

    @Override
    public String descricao() {
        return "Calça: " + marca + " | Cor: " + cor + " | Tamanho: " + tamanho + " | Preço: R$ " + String.format("%.2f", preco);
    }

    @Override
    public String toString() { return descricao(); }
}