package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable UUID id) {
        Optional<Funcionario> funcionario = funcionarioService.buscarPorId(id);
        return funcionario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Funcionario> buscarPorCpf(@PathVariable String cpf) {
        Optional<Funcionario> funcionario = funcionarioService.buscarPorCpf(cpf);
        return funcionario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvarFuncionario(@RequestBody Funcionario funcionario) {
        try {
            Funcionario funcionarioSalvo = funcionarioService.salvar(funcionario);
            return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable UUID id, @RequestBody Funcionario funcionario) {
        try {
            Funcionario funcionarioAtualizado = funcionarioService.atualizar(id, funcionario);
            return ResponseEntity.ok(funcionarioAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable UUID id) {
        try {
            funcionarioService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}