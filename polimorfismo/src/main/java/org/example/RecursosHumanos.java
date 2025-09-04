package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa operações de recursos humanos
 * Gerencia a admissão e demissão de funcionários
 */
public class RecursosHumanos implements Contratacao {

    private List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public void admitir(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário admitido: " + funcionario.getNome()); // Corrigido: usar getter
    }

    @Override
    public void demitir(Funcionario funcionario) {
        if (funcionarios.remove(funcionario)) {
            System.out.println("Funcionário demitido: " + funcionario.getNome()); // Corrigido: usar getter
        } else {
            System.out.println("Funcionário não encontrado: " + funcionario.getNome());
        }
    }

    /**
     * Método adicional para listar todos os funcionários
     */
    public void listarFuncionarios() {
        System.out.println("\n=== Lista de Funcionários ===");
        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + " - " + f.getSetor());
        }
    }
}