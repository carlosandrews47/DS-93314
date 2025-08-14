package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Lista {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ArrayList<Double> notas = new ArrayList<>();
        String resposta;

        do {
            double nota;
            do {
                System.out.println("Digite uma nota (entre 0 e 10):");
                nota = ler.nextDouble();
                if (nota < 0 || nota > 10) {
                    System.out.println("Nota inválida! Digite um valor entre 0 e 10.");
                }
            } while (nota < 0 || nota > 10); // ⚠️ Repete se a nota for inválida

            notas.add(nota); // ✅ Só adiciona se a nota for válida

            System.out.println("Digite uma nota:");
            notas.add(ler.nextDouble());
            System.out.println("Deseja inserir mais uma nota?");
            System.out.println("\nPressione a tecla N para sair:");
            resposta = ler.next();

        } while (!resposta.equalsIgnoreCase("n"));
        System.out.println("\nExibindo as notas: ");
        for (double nota : notas) {
            System.out.println("Nota: " + nota);
        }
    }
    }
