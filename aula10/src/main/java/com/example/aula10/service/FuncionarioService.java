package com.example.aula10.service;

import com.example.aula10.model.Funcionario;
import com.example.aula10.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public boolean existePorEmail(String email) {
        return funcionarioRepository.existsByEmail(email);
    }

    public boolean existePorMatricula(String matricula) {
        return funcionarioRepository.existsByMatricula(matricula);
    }


}
