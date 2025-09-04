package org.example;

/**
 * <<abstract>> Componente
 * - modelo comum para componentes de hardware ( "Usando herança, solicite os dados dos componentes")
 * - atributos comuns: marca, modelo
 */
public abstract class Componente {
    protected String marca;
    protected String modelo;

    public Componente(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }

    // cada componente explica seus dados
    public abstract String descricao();
}
