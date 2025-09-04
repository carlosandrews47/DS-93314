package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe Main:
 * - menu interativo no console para demonstrar cada grupo pedido :
 *   1) Pessoas (Física, Jurídica, Funcionários)
 *   2) Hardware (Processador, Memória, Placa mãe, Dispositivo de armazenamento)
 *   3) Produtos (Camisa, Calça, Sapato)
 *
 * O objetivo é "solicitar os dados conforme as informações abaixo" como nos prints.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Sistema de Demonstração de Herança ===");
        while (true) {
            System.out.println("\nEscolha o módulo: 1-Pessoas  2-Hardware  3-Produtos  0-Sair");
            String opc = sc.nextLine().trim();
            if (opc.equals("0")) break;
            switch (opc) {
                case "1": executarModuloPessoas(sc); break;
                case "2": executarModuloHardware(sc); break;
                case "3": executarModuloProdutos(sc); break;
                default: System.out.println("Opção inválida.");
            }
        }
        System.out.println("Encerrando. Até mais!");
        sc.close();
    }

    // ---------- Módulo Pessoas ----------
    private static void executarModuloPessoas(Scanner sc) {
        System.out.println("\n--- Módulo Pessoas ---");
        System.out.println("1-Física  2-Jurídica  3-Engenheiro  4-Médico");
        String opc = sc.nextLine().trim();
        switch (opc) {
            case "1": {
                System.out.print("Nome: "); String nome = sc.nextLine();
                System.out.print("Telefone: "); String tel = sc.nextLine();
                System.out.print("CPF: "); String cpf = sc.nextLine();
                System.out.print("RG: "); String rg = sc.nextLine();
                System.out.print("Data de nascimento: "); String nasc = sc.nextLine();
                Fisica f = new Fisica(nome, tel, cpf, rg, nasc);
                System.out.println("\nCriado: " + f);
                break;
            }
            case "2": {
                System.out.print("Razão social / Nome: "); String nome = sc.nextLine();
                System.out.print("Telefone: "); String tel = sc.nextLine();
                System.out.print("CNPJ: "); String cnpj = sc.nextLine();
                System.out.print("Inscrição estadual: "); String ie = sc.nextLine();
                Juridica j = new Juridica(nome, tel, cnpj, ie);
                System.out.println("\nCriada: " + j);
                break;
            }
            case "3": case "4": {
                // Criar Endereço (composição)
                System.out.print("Nome: "); String nome = sc.nextLine();
                System.out.print("Telefone: "); String tel = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Salário (ex: 3500.00): "); double salario = lerDouble(sc);
                System.out.print("Logradouro: "); String log = sc.nextLine();
                System.out.print("Número: "); String num = sc.nextLine();
                System.out.print("Complemento (vazio se não tiver): "); String comp = sc.nextLine();
                System.out.print("CEP: "); String cep = sc.nextLine();
                System.out.print("Cidade: "); String cidade = sc.nextLine();
                Endereco end = new Endereco(log, num, comp, cep, cidade);
                if (opc.equals("3")) {
                    System.out.print("CREA: "); String crea = sc.nextLine();
                    Engenheiro eng = new Engenheiro(nome, tel, email, salario, end, crea);
                    System.out.println("\nCriado: " + eng);
                } else {
                    System.out.print("CRM: "); String crm = sc.nextLine();
                    Medico med = new Medico(nome, tel, email, salario, end, crm);
                    System.out.println("\nCriado: " + med);
                }
                break;
            }
            default:
                System.out.println("Opção inválida no módulo Pessoas.");
        }
    }

    // ---------- Módulo Hardware ----------
    private static void executarModuloHardware(Scanner sc) {
        System.out.println("\n--- Módulo Hardware ---");
        List<Componente> lista = new ArrayList<>();

        System.out.println("Vamos cadastrar 1 processador:");
        System.out.print("Marca: "); String marca = sc.nextLine();
        System.out.print("Modelo: "); String modelo = sc.nextLine();
        System.out.print("Frequência (GHz): "); double freq = lerDouble(sc);
        lista.add(new Processador(marca, modelo, freq));

        System.out.println("\nAgora 1 memória:");
        System.out.print("Marca: "); marca = sc.nextLine();
        System.out.print("Modelo: "); modelo = sc.nextLine();
        System.out.print("Capacidade (GB): "); int cap = lerInt(sc);
        lista.add(new Memoria(marca, modelo, cap));

        System.out.println("\nAgora 1 placa-mãe:");
        System.out.print("Marca: "); marca = sc.nextLine();
        System.out.print("Modelo: "); modelo = sc.nextLine();
        System.out.print("Soquete: "); String soquete = sc.nextLine();
        lista.add(new PlacaMae(marca, modelo, soquete));

        System.out.println("\nAgora 1 dispositivo de armazenamento:");
        System.out.print("Marca: "); marca = sc.nextLine();
        System.out.print("Modelo: "); modelo = sc.nextLine();
        System.out.print("Capacidade (GB): "); cap = lerInt(sc);
        System.out.print("Tipo de conexão (ex: SATA, NVMe): "); String tipo = sc.nextLine();
        lista.add(new DispositivoArmazenamento(marca, modelo, cap, tipo));

        System.out.println("\n--- Componentes cadastrados ---");
        for (Componente c : lista) {
            System.out.println(" - " + c);
        }
    }

    // ---------- Módulo Produtos ----------
    private static void executarModuloProdutos(Scanner sc) {
        System.out.println("\n--- Módulo Produtos (vestuário) ---");
        System.out.println("Criaremos 1 Camisa, 1 Calça e 1 Sapato solicitando os dados.");
        System.out.println(">>> Camisa:");
        System.out.print("Marca: "); String marca = sc.nextLine();
        System.out.print("Cor: "); String cor = sc.nextLine();
        System.out.print("Tamanho: "); String tam = sc.nextLine();
        System.out.print("Preço: "); double preco = lerDouble(sc);
        Camisa camisa = new Camisa(marca, cor, tam, preco);

        System.out.println("\n>>> Calça:");
        System.out.print("Marca: "); marca = sc.nextLine();
        System.out.print("Cor: "); cor = sc.nextLine();
        System.out.print("Tamanho: "); tam = sc.nextLine();
        System.out.print("Preço: "); preco = lerDouble(sc);
        Calca calca = new Calca(marca, cor, tam, preco);

        System.out.println("\n>>> Sapato:");
        System.out.print("Marca: "); marca = sc.nextLine();
        System.out.print("Cor: "); cor = sc.nextLine();
        System.out.print("Tamanho: "); tam = sc.nextLine();
        System.out.print("Preço: "); preco = lerDouble(sc);
        Sapato sapato = new Sapato(marca, cor, tam, preco);

        System.out.println("\n--- Produtos cadastrados ---");
        System.out.println(camisa);
        System.out.println(calca);
        System.out.println(sapato);
    }

    // helpers para leitura segura de números
    private static double lerDouble(Scanner sc) {
        while (true) {
            try {
                String s = sc.nextLine().trim();
                return Double.parseDouble(s.replace(',', '.')); // aceita vírgula
            } catch (Exception e) {
                System.out.print("Valor inválido. Digite novamente: ");
            }
        }
    }

    private static int lerInt(Scanner sc) {
        while (true) {
            try {
                String s = sc.nextLine().trim();
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.print("Valor inválido. Digite novamente: ");
            }
        }
    }
}