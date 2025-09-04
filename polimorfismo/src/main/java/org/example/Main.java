package org.example;

import java.time.LocalDate;

/**
 * Classe principal que demonstra o funcionamento do sistema
 * Responsável por testar todas as funcionalidades implementadas:
 * - Operações matemáticas
 * - Comportamento de animais
 * - Sistema de funcionários
 */
public class Main {

    /**
     * Método principal - ponto de entrada da aplicação
     * @param args Argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        // === OPERAÇÕES MATEMÁTICAS ===
        // Cria instâncias das operações matemáticas
        OperacaoMatematica soma = new Soma();
        OperacaoMatematica subtracao = new Subtracao();
        OperacaoMatematica multiplicacao = new Multiplicacao();
        OperacaoMatematica divisao = new Divisao();

        // Valores para os cálculos
        double a = 10;
        double b = 5;

        System.out.println("=== Operações Matemáticas ===");
        System.out.println("Soma: " + a + " + " + b + " = " + soma.calcular(a, b));
        System.out.println("Subtração: " + a + " - " + b + " = " + subtracao.calcular(a, b));
        System.out.println("Multiplicação: " + a + " * " + b + " = " + multiplicacao.calcular(a, b));

        // Tratamento de exceção para divisão por zero
        try {
            System.out.println("Divisão: " + a + " / " + b + " = " + divisao.calcular(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Erro na divisão: " + e.getMessage());
        }

        // === ANIMAIS ===
        System.out.println("\n=== Animais ===");
        // Array com diferentes tipos de animais
        Animal1[] animais = {
                new Cachorro(),
                new Gato(),
                new Papagaio(),
                new Galo()
        };

        // Nomes correspondentes aos animais
        String[] nomesAnimais = {"Cachorro", "Gato", "Papagaio", "Galo"};

        // Itera sobre os animais mostrando seus comportamentos
        for (int i = 0; i < animais.length; i++) {
            System.out.println(nomesAnimais[i] + ": " +
                    animais[i].emitirSom() + " / " +
                    animais[i].comer());
        }

        // === FUNCIONÁRIOS ===
        System.out.println("\n=== Funcionários ===");

        // Criação de diferentes tipos de funcionários
        Motoboy motoboy = new Motoboy(
                "João",                    // nome
                "111.222.333-44",          // CPF
                "RG123456",                // RG
                Genero.MASCULINO,          // gênero
                Setor.OPERACOES,           // setor
                2500.0,                    // salário
                LocalDate.of(1990, 5, 15), // data nascimento
                LocalDate.of(2015, 1, 1),  // data admissão
                "AB123456"                 // CNH
        );

        Diretor diretor = new Diretor(
                "Maria",                   // nome
                "555.666.777-88",          // CPF
                "RG987654",                // RG
                Genero.FEMININO,           // gênero
                Setor.FINANCEIRO,          // setor
                10000.0,                   // salário
                LocalDate.of(1980, 8, 20), // data nascimento
                LocalDate.of(2010, 1, 1)   // data admissão
        );

        Gerente gerente = new Gerente(
                "Carlos",                  // nome
                "999.888.777-66",          // CPF
                "RG123789",                // RG
                Genero.MASCULINO,          // gênero
                Setor.ADMINISTRATIVO,      // setor
                7000.0,                    // salário
                LocalDate.of(1985, 3, 10), // data nascimento
                LocalDate.of(2020, 1, 1)   // data admissão
        );

        // Array com todos os funcionários
        Funcionario[] funcionarios = {motoboy, diretor, gerente};

        // Demonstração do sistema de recursos humanos
        System.out.println("\n=== Sistema de Recursos Humanos ===");
        RecursosHumanos rh = new RecursosHumanos();

        // Admitindo funcionários
        rh.admitir(motoboy);
        rh.admitir(diretor);
        rh.admitir(gerente);

        // Listando funcionários admitidos
        rh.listarFuncionarios();

        System.out.println("\n=== Demonstrativo de Funcionários ===");
        // Exibe informações detalhadas de cada funcionário
        for (Funcionario f : funcionarios) {
            System.out.println(f);
            System.out.println("Salário final: R$ " + String.format("%.2f", f.getSalarioFinal()));
            System.out.println("---");
        }
    }
}