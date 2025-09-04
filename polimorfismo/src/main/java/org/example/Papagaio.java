package org.example;

/**
 * Implementação da interface Animal1 para um papagaio
 * Define o som característico e a alimentação de um papagaio
 */
public class Papagaio implements Animal1 {

    @Override
    public String emitirSom() {
        return "Loro quer biscoito!";
    }

    @Override
    public String comer() {
        return "Frutas e sementes";
    }
}