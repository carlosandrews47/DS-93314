package com.example.aula6.service;

import com.example.aula6.model.Funcionario;
import com.example.aula6.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    // GET - Listar todos
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    // GET - Buscar por ID
    public Optional<Funcionario> buscarPorId(UUID id) {
        return funcionarioRepository.findById(id);
    }

    // POST - Salvar funcionário
    public Funcionario salvar(Funcionario funcionario) {
        // Verificar se já existe funcionário com o mesmo telefone
        Optional<Funcionario> funcionarioExistente = funcionarioRepository.findByTelefone(funcionario.getTelefone());

        if (funcionarioExistente.isPresent() && !funcionarioExistente.get().getId().equals(funcionario.getId())) {
            throw new RuntimeException("Já existe um funcionário com este telefone cadastrado");
        }

        return funcionarioRepository.save(funcionario);
    }

    // PUT - Atualizar funcionário
    public Funcionario atualizar(UUID id, Funcionario funcionarioAtualizado) {
        return funcionarioRepository.findById(id)
                .map(funcionario -> {
                    funcionario.setNome(funcionarioAtualizado.getNome());
                    funcionario.setTelefone(funcionarioAtualizado.getTelefone());
                    return funcionarioRepository.save(funcionario);
                })
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com ID: " + id));
    }

    // DELETE - Deletar funcionário
    public void deletar(UUID id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado com ID: " + id);
        }
        funcionarioRepository.deleteById(id);
    }

    // Buscar por telefone
    public Optional<Funcionario> buscarPorTelefone(String telefone) {
        return funcionarioRepository.findByTelefone(telefone);
    }

    // Verificar se existe por ID
    public boolean existePorId(UUID id) {
        return funcionarioRepository.existsById(id);
    }
}