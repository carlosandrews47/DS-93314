package com.example.aula14.controller;

import com.example.aula14.dto.UsuarioRequestDTO;
import com.example.aula14.dto.UsuarioResponseDTO;
import com.example.aula14.model.UsuarioModel;
import com.example.aula14.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Salvar novo usuário
    @PostMapping
    public ResponseEntity<UsuarioModel> salvarUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioModel usuarioSalvo = usuarioService.salvarUsuario(usuarioRequestDTO);
        return ResponseEntity.ok(usuarioSalvo);
    }

    // Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        List<UsuarioResponseDTO> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    // Buscar usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> buscarPorId(@PathVariable Long id) {
        Optional<UsuarioModel> usuario = usuarioService.buscarPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar usuário por email
    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioModel> buscarPorEmail(@PathVariable String email) {
        Optional<UsuarioModel> usuario = usuarioService.buscarPorEmail(email);
        return usuario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Verificar se email existe
    @GetMapping("/verificar-email/{email}")
    public ResponseEntity<Boolean> verificarEmail(@PathVariable String email) {
        boolean existe = usuarioService.verificarEmail(email);
        return ResponseEntity.ok(existe);
    }

    // Atualizar usuário
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> atualizarUsuario(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioModel usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioRequestDTO);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    // Deletar usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    // Ativar/desativar usuário
    @PatchMapping("/{id}/ativo")
    public ResponseEntity<UsuarioModel> ativarDesativarUsuario(@PathVariable Long id) {
        UsuarioModel usuario = usuarioService.ativarDesativarUsuario(id);
        return ResponseEntity.ok(usuario);
    }

    // Buscar usuários ativos
    @GetMapping("/ativos")
    public ResponseEntity<List<UsuarioResponseDTO>> buscarAtivos() {
        List<UsuarioResponseDTO> usuariosAtivos = usuarioService.buscarAtivos();
        return ResponseEntity.ok(usuariosAtivos);
    }

    // Buscar usuários por nome
    @GetMapping("/buscar")
    public ResponseEntity<List<UsuarioResponseDTO>> buscarPorNome(@RequestParam String nome) {
        List<UsuarioResponseDTO> usuarios = usuarioService.buscarPorNome(nome);
        return ResponseEntity.ok(usuarios);
    }
}