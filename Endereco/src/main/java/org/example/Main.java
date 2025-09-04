package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Entrada de dados do Cliente
            System.out.print("Digite o nome do cliente: ");
            String nome = sc.nextLine();

            System.out.print("Digite a idade do cliente: ");
            int idade = Integer.parseInt(sc.nextLine());

            // Entrada de dados do Endereco
            System.out.print("Digite o logradouro: ");
            String logradouro = sc.nextLine();

            System.out.print("Digite o número: ");
            int numero = Integer.parseInt(sc.nextLine());

            System.out.print("Digite a cidade: ");
            String cidade = sc.nextLine();

            // Criando os objetos
            Endereco endereco = new Endereco(logradouro, numero, cidade);
            Cliente cliente = new Cliente(nome, idade, endereco);

            // Exibindo os dados do cliente
            System.out.println("\n--- Dados do Cliente ---");
            System.out.println(cliente);

            sc.close();
        }
    }

