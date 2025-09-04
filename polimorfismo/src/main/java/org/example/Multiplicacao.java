package org.example;

/**
 * Implementação da operação de multiplicação matemática
 * Realiza a multiplicação de dois números double
 */
public class Multiplicacao implements OperacaoMatematica {
    @Override
    public double calcular(double a, double b) {
        return a * b;
    }
}