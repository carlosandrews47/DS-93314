public class Main {

    public static void main(String[] args) {

        // Criando livros com ISBN
        Livro livro1 = new Livro("Clean Code", "Robert C. Martin", 464, 252.90, "978-0132350884");
        Livro livro2 = new Livro("O Programador Pragmático", "Andrew Hunt", 400, 900.00, "978-8576082675");

        System.out.println("=== Dados dos livros ===");
        System.out.println(livro1);
        System.out.println(livro2);

        // Calculando valor total da compra
        int quantidadeLivro1 = 2;
        int quantidadeLivro2 = 3;

        System.out.println("\n=== Valor total da compra ===");
        System.out.printf("30 cópias de Clean Code: R$ %.2f%n", livro1.calcularTotal(quantidadeLivro1));
        System.out.printf("50 cópias de O Programador Pragmático: R$ %.2f%n", livro2.calcularTotal(quantidadeLivro2));
        System.out.printf("Total da compra: R$ %.2f%n",
                livro1.calcularTotal(quantidadeLivro1) + livro2.calcularTotal(quantidadeLivro2));

        // Criando veículos
        Veiculo veiculo1 = new Veiculo("ABC1234", "Vermelho", 50.0, 180.0, 12.5);
        Veiculo veiculo2 = new Veiculo("XYZ5678", "Azul", 45.0, 200.0, 10.0);

        System.out.println("\n=== Dados dos veículos ===");
        System.out.println(veiculo1);
        System.out.println("Autonomia: " + veiculo1.calcularAutonomia() + "km");

        System.out.println("\n" + veiculo2);
        System.out.println("Autonomia: " + veiculo2.calcularAutonomia() + "km");

        // Criando clientes (NOVO)
        Cliente cliente1 = new Cliente("João Silva", 30, "123.456.789-00",
                "Rua das Flores, 123 - Centro", "(11) 99999-9999");
        Cliente cliente2 = new Cliente("Maria Santos", 25, "987.654.321-00",
                "Av. Principal, 456 - Jardim", "(11) 98888-8888");

        System.out.println("\n=== Dados dos clientes ===");
        System.out.println(cliente1);
        System.out.println(cliente2);

        // Demonstração de integração entre as classes
        System.out.println("\n=== Sistema Integrado ===");
        System.out.println("Cliente: " + cliente1.getNome());
        System.out.println("Comprou: " + quantidadeLivro1 + " x " + livro1.getTitulo());
        System.out.printf("Valor: R$ %.2f%n", livro1.calcularTotal(quantidadeLivro1));
        System.out.println("Entregar via veículo: " + veiculo1.getPlaca());
        System.out.println("No endereço: " + cliente1.getEndereco());
    }
 }