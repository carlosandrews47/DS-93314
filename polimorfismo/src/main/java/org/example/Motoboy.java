package org.example;

import java.time.LocalDate;

/**
 * Classe que representa um Motoboy na empresa
 * Estende Funcionario sem bonificação
 */
public class Motoboy extends Funcionario {

    private String cnh;

    public Motoboy(String nome, String cpf, String rg, Genero genero, Setor setor,
                   double salario, LocalDate dataNascimento, LocalDate dataAdmissao, String cnh) {
        super(nome, cpf, rg, genero, setor, salario, dataNascimento, dataAdmissao);
        this.cnh = cnh;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    @Override
    public double getSalarioFinal() {
        return getSalario(); // Sem bonificação
    }

    @Override
    public String toString() {
        return "Motoboy{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", setor=" + getSetor() +
                ", salario=" + getSalario() +
                ", cnh='" + cnh + '\'' +
                '}';
    }
}