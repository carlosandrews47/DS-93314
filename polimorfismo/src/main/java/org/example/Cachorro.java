package org.example;

public class Cachorro implements Animal1 {

    @Override
    public String emitirSom() {
        return "Auau";
    }

    @Override
    public String comer() {
        return "Ração para cachorro";
    }
}