package org.example;

class Divisao implements OperacaoMatematica {
    @Override
    public double calcular(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }
        return a / b;
    }
}
