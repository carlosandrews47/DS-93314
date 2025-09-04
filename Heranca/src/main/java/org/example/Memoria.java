package org.example;

/**
 * Memória ( Marca, Modelo, Capacidade de armazenamento)
 */
public class Memoria extends Componente {
    private int capacidadeGB;

    public Memoria(String marca, String modelo, int capacidadeGB) {
        super(marca, modelo);
        this.capacidadeGB = capacidadeGB;
    }

    public int getCapacidadeGB() { return capacidadeGB; }

    @Override
    public String descricao() {
        return "Memória: " + marca + " " + modelo + " - " + capacidadeGB + " GB";
    }

    @Override
    public String toString() { return descricao(); }
}