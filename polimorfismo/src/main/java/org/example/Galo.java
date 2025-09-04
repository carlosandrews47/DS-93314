package org.example;

public class Galo implements Animal1{

    @Override
    public String emitirSom() {
        return "CACAREJA";
    }

    @Override
    public String comer() {
        return "MILHO PARA  GALO";
    }
}
