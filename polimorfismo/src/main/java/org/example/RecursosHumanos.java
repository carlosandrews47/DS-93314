package org.example;

import java.util.ArrayList;
import java.util.List;

public class RecursosHumanos implements Contratacao {

    private List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public void admitir(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário admitido: " + funcionario.nome);
    }

    @Override
    public void demitir(Funcionario funcionario) {
        funcionarios.remove(funcionario);
        System.out.println("Funcionário demitido: " + funcionario.nome);
    }
}
