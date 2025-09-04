package org.example;

public class Papagaio implements Animal1 {

    @Override
    public String emitirSom() {
        return "Loro quer biscoito!"; // papagaio costuma repetir frases
    }

    @Override
    public String comer() {
        return "Frutas e sementes"; // dieta típica de papagaio
    }
}
