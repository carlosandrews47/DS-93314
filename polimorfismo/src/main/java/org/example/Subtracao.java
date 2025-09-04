package org.example;

/**
 * Implementação da operação de subtração matemática
 * Realiza a subtração de dois números double
 */
public class Subtracao implements OperacaoMatematica {
    @Override
    public double calcular(double a, double b) {
        return a - b;
    }
}