package org.example;

public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String texto;

    Genero(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
