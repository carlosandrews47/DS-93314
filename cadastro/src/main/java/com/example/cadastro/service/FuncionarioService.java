package com.example.cadastro.service;

import com.example.cadastro.entity.Funcionario;
import com.example.cadastro.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario saveFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deleteFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public Funcionario updateFuncionario(Long id, Funcionario funcionarioDetails) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);

        if (optionalFuncionario.isPresent()) {
            Funcionario funcionario = optionalFuncionario.get();

            funcionario.setNome(funcionarioDetails.getNome());
            funcionario.setCpf(funcionarioDetails.getCpf());
            funcionario.setRg(funcionarioDetails.getRg());
            funcionario.setMatricula(funcionarioDetails.getMatricula());
            funcionario.setDataNascimento(funcionarioDetails.getDataNascimento());
            funcionario.setSexo(funcionarioDetails.getSexo());
            funcionario.setSetor(funcionarioDetails.getSetor());
            funcionario.setSalario(funcionarioDetails.getSalario());
            funcionario.setTelefone(funcionarioDetails.getTelefone());
            funcionario.setEmail(funcionarioDetails.getEmail());
            funcionario.setEndereco(funcionarioDetails.getEndereco());

            return funcionarioRepository.save(funcionario);
        }
        return null;
    }
}