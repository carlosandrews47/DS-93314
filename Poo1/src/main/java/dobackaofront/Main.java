package dobackaofront;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instanciando uma Pessoa corretamente
        Pessoa p1 = new Pessoa("Marta", 25); // Removido o parâmetro nomeado "idade:"

        // Instanciando um Produto corretamente
        Produto produto1 = new Produto("Arroz", 5.99); // Nome e preço como valores diretos

        Scanner ler = new Scanner(System.in);

        // As linhas abaixo são redundantes pois já definimos no construtor
        // p1.setNome("Marta");
        // p1.setIdade(25);

        System.out.println("Nome: " + p1.getNome());
        System.out.println("Idade: " + p1.getIdade());

        // Mostrando informações do produto também
        System.out.println("\nProduto: " + produto1.getNome());
        System.out.println("Preço unitário: R$" + produto1.getPrecoUnitario());
    }
}