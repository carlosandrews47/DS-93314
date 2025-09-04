package org.example;

public class Juridica extends Pessoa {
    private String cnpj;
    private String inscricaoEstadual;

    public Juridica(String nome, String telefone, String cnpj, String inscricaoEstadual) {
        super(nome, telefone);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCnpj() { return cnpj; }
    public String getInscricaoEstadual() { return inscricaoEstadual; }

    @Override
    public String getTipo() { return "Pessoa Jurídica"; }

    @Override
    public String toString() {
        return super.toString() + " | CNPJ: " + cnpj + " | IE: " + inscricaoEstadual;
    }
}