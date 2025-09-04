package org.example;

/**
 * Sapato (herda Produto)
 */
public class Sapato extends Produto {
    public Sapato(String marca, String cor, String tamanho, double preco) {
        super(marca, cor, tamanho, preco);
    }

    @Override
    public String descricao() {
        return "Sapato: " + marca + " | Cor: " + cor + " | Tamanho: " + tamanho + " | Preço: R$ " + String.format("%.2f", preco);
    }

    @Override
    public String toString() { return descricao(); }
}
