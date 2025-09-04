package org.example;

/**
 * Processador ( Marca, Modelo, Frequência)
 */
public class Processador extends Componente {
    private double frequenciaGHz; // em GHz

    public Processador(String marca, String modelo, double frequenciaGHz) {
        super(marca, modelo);
        this.frequenciaGHz = frequenciaGHz;
    }

    public double getFrequenciaGHz() { return frequenciaGHz; }

    @Override
    public String descricao() {
        return "Processador: " + marca + " " + modelo + " - " + frequenciaGHz + " GHz";
    }

    @Override
    public String toString() { return descricao(); }
}

