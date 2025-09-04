package org.example;

public enum Bonificacao {
    GERENTE(0.15),   // 15% de bonificação
    DIRETOR(0.20);   // 20% de bonificação

    private final double valor;

    Bonificacao(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
      }

    }