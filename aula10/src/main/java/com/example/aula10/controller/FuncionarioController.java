package com.example.aula10.controller;

import com.example.aula10.dto.RespostaApi;
import com.example.aula10.model.Funcionario;
import com.example.aula10.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // GET - Listar todos os funcionários
    @GetMapping
    public ResponseEntity<RespostaApi> listarTodos() {
        try {
            List<Funcionario> funcionarios = funcionarioService.listarTodos();
            RespostaApi resposta = new RespostaApi(true, "Funcionários listados com sucesso", funcionarios);
            return ResponseEntity.ok(resposta);
        } catch (Exception e) {
            RespostaApi resposta = new RespostaApi(false, "Erro ao listar funcionários: " + e.getMessage());
            return ResponseEntity.badRequest().body(resposta);
        }
    }

    // GET - Buscar funcionário por ID
    @GetMapping("/{id}")
    public ResponseEntity<RespostaApi> buscarPorId(@PathVariable Long id) {
        try {
            Optional<Funcionario> funcionario = funcionarioService.buscarPorId(id);
            if (funcionario.isPresent()) {
                RespostaApi resposta = new RespostaApi(true, "Funcionário encontrado", funcionario.get());
                return ResponseEntity.ok(resposta);
            } else {
                RespostaApi resposta = new RespostaApi(false, "Funcionário não encontrado");
                return ResponseEntity.badRequest().body(resposta);
            }
        } catch (Exception e) {
            RespostaApi resposta = new RespostaApi(false, "Erro ao buscar funcionário: " + e.getMessage());
            return ResponseEntity.badRequest().body(resposta);
        }
    }

    // POST - Criar novo funcionário
    @PostMapping
    public ResponseEntity<RespostaApi> criar(@Valid @RequestBody Funcionario funcionario) {
        try {
            // Verificar se email já existe
            if (funcionarioService.existePorEmail(funcionario.getEmail())) {
                RespostaApi resposta = new RespostaApi(false, "Funcionário já cadastrado com este email");
                return ResponseEntity.badRequest().body(resposta);
            }

            // Verificar se matrícula já existe
            if (funcionarioService.existePorMatricula(funcionario.getMatricula())) {
                RespostaApi resposta = new RespostaApi(false, "Funcionário já cadastrado com esta matrícula");
                return ResponseEntity.badRequest().body(resposta);
            }

            Funcionario funcionarioSalvo = funcionarioService.salvar(funcionario);
            RespostaApi resposta = new RespostaApi(true, "Funcionário cadastrado com sucesso", funcionarioSalvo);
            return ResponseEntity.ok(resposta);

        } catch (Exception e) {
            RespostaApi resposta = new RespostaApi(false, "Erro ao cadastrar funcionário: " + e.getMessage());
            return ResponseEntity.badRequest().body(resposta);
        }
    }

    // PUT - Atualizar funcionário
    @PutMapping("/{id}")
    public ResponseEntity<RespostaApi> atualizar(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
        try {
            if (!funcionarioService.buscarPorId(id).isPresent()) {
                RespostaApi resposta = new RespostaApi(false, "Funcionário não encontrado");
                return ResponseEntity.badRequest().body(resposta);
            }

            funcionario.setId(id);
            Funcionario funcionarioAtualizado = funcionarioService.salvar(funcionario);
            RespostaApi resposta = new RespostaApi(true, "Funcionário atualizado com sucesso", funcionarioAtualizado);
            return ResponseEntity.ok(resposta);

        } catch (Exception e) {
            RespostaApi resposta = new RespostaApi(false, "Erro ao atualizar funcionário: " + e.getMessage());
            return ResponseEntity.badRequest().body(resposta);
        }
    }

    // DELETE - Deletar funcionário
    @DeleteMapping("/{id}")
    public ResponseEntity<RespostaApi> deletar(@PathVariable Long id) {
        try {
            if (!funcionarioService.buscarPorId(id).isPresent()) {
                RespostaApi resposta = new RespostaApi(false, "Funcionário não encontrado");
                return ResponseEntity.badRequest().body(resposta);
            }

            funcionarioService.deletar(id);
            RespostaApi resposta = new RespostaApi(true, "Funcionário deletado com sucesso");
            return ResponseEntity.ok(resposta);

        } catch (Exception e) {
            RespostaApi resposta = new RespostaApi(false, "Erro ao deletar funcionário: " + e.getMessage());
            return ResponseEntity.badRequest().body(resposta);
        }
    }
}