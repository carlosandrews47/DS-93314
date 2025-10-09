package com.example.AULA9.service;

import com.example.AULA9.model.FuncionarioModel;
import com.example.AULA9.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioModel> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Optional<FuncionarioModel> buscarPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public FuncionarioModel salvar(FuncionarioModel funcionarioModel) {
        return funcionarioRepository.save(funcionarioModel);
    }

    public void excluir(Long id) {
        funcionarioRepository.deleteById(id);
    }
}