package org.example;

public class Gato implements Animal1 {

    @Override
    public String emitirSom() {
        return "Miau"; // som do gato
    }

    @Override
    public String comer() {
        return "Ração para gato"; // comida típica de gato
    }
}
