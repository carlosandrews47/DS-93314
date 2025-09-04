package org.example;

/**
 * Implementação da operação de soma matemática
 * Realiza a adição de dois números double
 */
public class Soma implements OperacaoMatematica {
    @Override
    public double calcular(double a, double b) {
        return a + b;
    }
}