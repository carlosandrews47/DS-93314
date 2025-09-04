package org.example;

public class Fisica extends Pessoa {
    private String cpf;
    private String rg;
    private String dataNascimento;

    public Fisica(String nome, String telefone, String cpf, String rg, String dataNascimento) {
        super(nome, telefone);
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() { return cpf; }
    public String getRg() { return rg; }
    public String getDataNascimento() { return dataNascimento; }

    @Override
    public String getTipo() { return "Pessoa Física"; }

    @Override
    public String toString() {
        // mantém informações da superclasse e acrescenta campos específicos
        return super.toString() + " | CPF: " + cpf + " | RG: " + rg + " | Nasc: " + dataNascimento;
    }
}