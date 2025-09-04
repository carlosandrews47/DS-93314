package org.example;

public class Medico extends Funcionario {
    private String crm; // registro médico

    public Medico(String nome, String telefone, String email, double salario, Endereco endereco, String crm) {
        super(nome, telefone, email, salario, endereco);
        this.crm = crm;
    }

    public String getCrm() { return crm; }

    @Override
    public String getCargo() { return "Médico"; }

    @Override
    public String toString() {
        return getCargo() + " - " + super.toString() + " | CRM: " + crm;
    }
}
