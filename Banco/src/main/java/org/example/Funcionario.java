public class Funcionario {
    // Atributos existentes (mantenha-os)
    private final String codigoFuncionario;
    private final String nome;
    private final String endereco;
    private final String telefone;
    private final String email;
    private final ContaBancaria contaBancaria;

    // Novos atributos (adicionados)
    private final int id;
    private final double salario;
    private final SETOR setor;
    private final SEXO sexo;
    private final int idade;

    // Construtor atualizado (adicione os novos parâmetros)
    public Funcionario(String codigoFuncionario, String nome, String endereco,
                       String telefone, String email, ContaBancaria contaBancaria,
                       int id, double salario, SETOR setor, SEXO sexo, int idade) {
        // Atributos existentes
        this.codigoFuncionario = codigoFuncionario;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.contaBancaria = contaBancaria;

        // Novos atributos
        this.id = id;
        this.salario = salario;
        this.setor = setor;
        this.sexo = sexo;
        this.idade = idade;
    }

    // Mantenha todos os getters existentes...
    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    // Adicione os novos getters
    public int getId() {
        return id;
    }

    public double getSalario() {
        return salario;
    }

    public SETOR getSetor() {
        return setor;
    }

    public SEXO getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }

    // Método para receber salário (atualizado para usar o novo atributo salario)
    public void receberSalario() {
        System.out.printf("\n%s está recebendo salário de R$ %.2f%n", nome, salario);
        contaBancaria.depositar(salario);
    }

    // Método para aumentar salário (novo)
    public void aumentarSalario(double percentual) {
        double aumento = salario * (percentual / 100);
        System.out.printf("Salário de %s aumentado em %.1f%%. Novo salário: R$ %.2f%n",
                nome, percentual, salario + aumento);
    }

    // Método para exibir dados do funcionário (atualizado)
    public void exibirDados() {
        System.out.println("\n=== DADOS DO FUNCIONÁRIO ===");
        System.out.println("Código: " + codigoFuncionario);
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Sexo: " + sexo);
        System.out.println("Setor: " + setor);
        System.out.printf("Salário: R$ %.2f%n", salario);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("E-mail: " + email);
        System.out.println("\n--- Dados Bancários ---");
        System.out.println(contaBancaria);
    }

    // toString atualizado
    @Override
    public String toString() {
        return String.format("Código: %s | ID: %d | Nome: %s | Idade: %d | Sexo: %s | Setor: %s | Salário: R$ %.2f",
                codigoFuncionario, id, nome, idade, sexo, setor, salario);
    }
}

