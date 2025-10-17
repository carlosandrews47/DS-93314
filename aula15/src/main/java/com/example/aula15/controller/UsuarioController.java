package com.example.aula15.controller;

import com.example.aula15.dto.UsuarioRequestDTO;
import com.example.aula15.model.UsuarioModel;
import com.example.aula15.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // CREATE
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody UsuarioRequestDTO dto) {
        usuarioService.salvarUsuario(dto);
        return ResponseEntity
                .created(null)
                .body(Map.of(
                        "mensagem", "Usuário criado com sucesso",
                        "sucesso", true
                ));
    }

    // READ
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> listarTodos() {
        return ResponseEntity
                .ok()
                .body(usuarioService.buscarTodosUsuarios());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> buscarPorId(@PathVariable Long id) {
        UsuarioModel usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id,
                                                         @Valid @RequestBody UsuarioRequestDTO dto) {
        usuarioService.atualizarUsuario(id, dto);
        return ResponseEntity
                .ok()
                .body(Map.of(
                        "mensagem", "Usuário atualizado com sucesso",
                        "sucesso", true
                ));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity
                .ok()
                .body(Map.of(
                        "mensagem", "Usuário excluído com sucesso",
                        "sucesso", true
                ));
    }
}