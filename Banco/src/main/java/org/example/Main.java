public class Main {

    public static void main(String[] args) {
        // Criando contas bancárias (mantenha isso se ainda for necessário)
        ContaBancaria conta1 = new ContaBancaria("Banco do Brasil", "1234-5", "98765-4",
                "Corrente", 1500.00, 2000.00);

        ContaBancaria conta2 = new ContaBancaria("Itaú", "5678-9", "12345-6",
                "Poupança", 3000.00, 1000.00);

        // Criando funcionários com os NOVOS parâmetros
        Funcionario funcionario1 = new Funcionario("F001", "João Silva",
                "Rua das Flores, 123 - Centro",
                "(11) 99999-9999", "joao.silva@empresa.com",
                conta1,
                1, 4500.00, SETOR.FINANCEIRO, SEXO.MASCULINO, 35);

        Funcionario funcionario2 = new Funcionario("F002", "Maria Santos",
                "Av. Principal, 456 - Jardim",
                "(11) 98888-8888", "maria.santos@empresa.com",
                conta2,
                2, 5200.00, SETOR.RH, SEXO.FEMININO, 28);

        System.out.println("=== SISTEMA DE FUNCIONÁRIOS ATUALIZADO ===");

        // Exibindo dados dos funcionários
        funcionario1.exibirDados();
        funcionario2.exibirDados();

        // Operações com salário
        System.out.println("\n=== OPERAÇÕES DE SALÁRIO ===");
        funcionario1.receberSalario();
        funcionario2.receberSalario();

        // Aumento de salário
        System.out.println("\n=== AUMENTOS DE SALÁRIO ===");
        funcionario1.aumentarSalario(10.0);
        funcionario2.aumentarSalario(15.0);

        // Extratos bancários
        System.out.println("\n=== EXTRATOS BANCÁRIOS ===");
        conta1.exibirExtrato();
        conta2.exibirExtrato();

        // Usando o método toString
        System.out.println("\n=== LISTA DE FUNCIONÁRIOS ===");
        System.out.println(funcionario1);
        System.out.println(funcionario2);
    }
}