package com.example.cadastro.controller;

import com.example.cadastro.entity.Funcionario;
import com.example.cadastro.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // GET - Listar todos os funcionários
    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.getAllFuncionarios();
    }

    // GET - Buscar funcionário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.getFuncionarioById(id);
        return funcionario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - Criar novo funcionário
    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.saveFuncionario(funcionario);
    }

    // PUT - Atualizar funcionário
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id,
                                                         @RequestBody Funcionario funcionarioDetails) {
        Funcionario updatedFuncionario = funcionarioService.updateFuncionario(id, funcionarioDetails);
        return updatedFuncionario != null ?
                ResponseEntity.ok(updatedFuncionario) :
                ResponseEntity.notFound().build();
    }

    // DELETE - Deletar funcionário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.getFuncionarioById(id);
        if (funcionario.isPresent()) {
            funcionarioService.deleteFuncionario(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
