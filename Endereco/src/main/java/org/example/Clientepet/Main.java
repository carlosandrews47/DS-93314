package org.example.Clientepet;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Dados do cliente
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = sc.nextLine();

        System.out.print("Digite a idade do cliente: ");
        int idadeCliente = Integer.parseInt(sc.nextLine());

        // Dados do pet
        System.out.print("Digite o nome do pet: ");
        String nomePet = sc.nextLine();

        System.out.print("Digite a idade do pet: ");
        int idadePet = Integer.parseInt(sc.nextLine());

        System.out.print("Digite a raça do pet: ");
        String racaPet = sc.nextLine();

        // Criando os objetos
        Pet pet = new Pet(nomePet, idadePet, racaPet);
        Cliente cliente = new Cliente(nomeCliente, idadeCliente, pet);

        // Exibindo resultado
        System.out.println("\n--- Dados do Cliente ---");
        System.out.println(cliente);

        sc.close();
    }
}

