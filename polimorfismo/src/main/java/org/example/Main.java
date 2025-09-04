import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // === Operações Matemáticas ===
        OperacaoMatematica soma = new Soma();
        OperacaoMatematica subtracao = new Subtracao();
        OperacaoMatematica multiplicacao = new Multiplicacao();
        OperacaoMatematica divisao = new Divisao();

        double a = 10;
        double b = 5;

        System.out.println("=== Operações Matemáticas ===");
        System.out.println("Soma: " + soma.calcular(a, b));
        System.out.println("Subtração: " + subtracao.calcular(a, b));
        System.out.println("Multiplicação: " + multiplicacao.calcular(a, b));
        System.out.println("Divisão: " + divisao.calcular(a, b));

        // === Animais ===
        System.out.println("\n=== Animais ===");
        Animal1[] animais = {new Cachorro(), new Gato(), new Papagaio(), new Galo()};
        String[] nomesAnimais = {"Cachorro", "Gato", "Papagaio", "Galo"};

        for (int i = 0; i < animais.length; i++) {
            System.out.println(nomesAnimais[i] + ": " + animais[i].emitirSom() + " / " + animais[i].comer());
        }

        // === Funcionários ===
        System.out.println("\n=== Funcionários ===");

        Motoboy motoboy = new Motoboy(
                "João",
                "111.222.333-44",
                "RG123456",
                Genero.MASCULINO,
                Setor.OPERACOES,
                2500.0,
                LocalDate.of(1990, 5, 15),
                LocalDate.of(2015, 1, 1),
                "AB123456"
        );

        Diretor diretor = new Diretor(
                "Maria",
                "555.666.777-88",
                "RG987654",
                Genero.FEMININO,
                Setor.FINANCEIRO,
                10000.0,
                LocalDate.of(1980, 8, 20),
                LocalDate.of(2010, 1, 1)
        );

        Gerente gerente = new Gerente(
                "Carlos",
                "999.888.777-66",
                "RG123789",
                Genero.MASCULINO,
                Setor.ADMINISTRATIVO,
                7000.0,
                LocalDate.of(1985, 3, 10),
                LocalDate.of(2020, 1, 1)
        );

        Funcionario[] funcionarios = {motoboy, diretor, gerente};

        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }
}