package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarPorId(UUID id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario salvar(Funcionario funcionario) {
        if (funcionarioRepository.existsByCpf(funcionario.getCpf())) {
            throw new RuntimeException("Já existe um funcionário com este CPF");
        }
        if (funcionarioRepository.existsByMatricula(funcionario.getMatricula())) {
            throw new RuntimeException("Já existe um funcionário com esta matrícula");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(UUID id, Funcionario funcionarioAtualizado) {
        return funcionarioRepository.findById(id)
                .map(funcionario -> {
                    if (!funcionario.getCpf().equals(funcionarioAtualizado.getCpf()) &&
                            funcionarioRepository.existsByCpf(funcionarioAtualizado.getCpf())) {
                        throw new RuntimeException("Já existe outro funcionário com este CPF");
                    }
                    if (!funcionario.getMatricula().equals(funcionarioAtualizado.getMatricula()) &&
                            funcionarioRepository.existsByMatricula(funcionarioAtualizado.getMatricula())) {
                        throw new RuntimeException("Já existe outro funcionário com esta matrícula");
                    }

                    funcionario.setNome(funcionarioAtualizado.getNome());
                    funcionario.setCpf(funcionarioAtualizado.getCpf());
                    funcionario.setRg(funcionarioAtualizado.getRg());
                    funcionario.setMatricula(funcionarioAtualizado.getMatricula());
                    funcionario.setDataNascimento(funcionarioAtualizado.getDataNascimento());

                    return funcionarioRepository.save(funcionario);
                })
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com ID: " + id));
    }

    public void deletar(UUID id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado com ID: " + id);
        }
        funcionarioRepository.deleteById(id);
    }

    public Optional<Funcionario> buscarPorCpf(String cpf) {
        return funcionarioRepository.findByCpf(cpf);
    }

    public Optional<Funcionario> buscarPorMatricula(String matricula) {
        return funcionarioRepository.findByMatricula(matricula);
    }
}