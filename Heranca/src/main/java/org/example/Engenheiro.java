package org.example;

public class Engenheiro extends Funcionario {
    private String crea; // registro profissional

    public Engenheiro(String nome, String telefone, String email, double salario, Endereco endereco, String crea) {
        super(nome, telefone, email, salario, endereco);
        this.crea = crea;
    }

    public String getCrea() { return crea; }

    @Override
    public String getCargo() { return "Engenheiro"; }

    @Override
    public String toString() {
        // demonstra acesso ao campo 'nome' da classe-pai usando protected
        return getCargo() + " - " + super.toString() + " | CREA: " + crea;
    }
}
