package org.example;

/**
 * <<abstract>> Funcionario (slide)
 * - mostra herança: Funcionario herda de Pessoa (nome e telefone)
 * - contém: email, salario, endereco (composição)
 * - abstrato porque cargos específicos (Engenheiro, Medico) concretizam
 */
public abstract class Funcionario extends Pessoa {
    protected String email;
    protected double salario;
    protected Endereco endereco; // composição: Funcionario tem um Endereco

    public Funcionario(String nome, String telefone, String email, double salario, Endereco endereco) {
        super(nome, telefone);
        this.email = email;
        this.salario = salario;
        this.endereco = endereco;
    }

    public String getEmail() { return email; }
    public double getSalario() { return salario; }
    public Endereco getEndereco() { return endereco; }

    // cada funcionário concreto pode ter sua descrição/cálculo próprio
    public abstract String getCargo();

    @Override
    public String getTipo() {
        return "Funcionário";
    }

    @Override
    public String toString() {
        return super.toString() + " | Email: " + email + " | Salário: R$ " + String.format("%.2f", salario)
                + " | Endereço: " + (endereco != null ? endereco.toString() : "N/A");
    }
}
