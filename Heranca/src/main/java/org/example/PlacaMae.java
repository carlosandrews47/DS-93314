package org.example;

/**
 * Placa mãe (slide: Marca, Modelo, Soquete)
 */
public class PlacaMae extends Componente {
    private String soquete;

    public PlacaMae(String marca, String modelo, String soquete) {
        super(marca, modelo);
        this.soquete = soquete;
    }

    public String getSoquete() { return soquete; }

    @Override
    public String descricao() {
        return "Placa Mãe: " + marca + " " + modelo + " - Soquete: " + soquete;
    }

    @Override
    public String toString() { return descricao(); }
}
