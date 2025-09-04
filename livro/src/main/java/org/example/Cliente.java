

public class Cliente {

    private final String nome;
    private final int idade;
    private final String cpf;
    private final String endereco;
    private final String telefone;

    public Cliente(String nome, int idade, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | Idade: %d | CPF: %s | Endereço: %s | Telefone: %s",
                nome, idade, cpf, endereco, telefone);
    }
 }

