package com.example.aula8.controller;

import com.example.aula8.model.UsuarioModel;
import com.example.aula8.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    // ✅ CRIAR USUÁRIO
    @PostMapping
    public ResponseEntity<Map<String, Object>> criarUsuario(@Valid @RequestBody UsuarioModel usuario) {
        try {
            if (usuarioService.emailExiste(usuario.getEmail())) {
                return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "Erro ao criar usuário",
                    "error", "Email já está cadastrado",
                    "email", usuario.getEmail(),
                    "timestamp", System.currentTimeMillis()
                ));
            }
            
            UsuarioModel usuarioSalvo = usuarioService.salvarUsuario(usuario);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "success", true,
                "message", "Usuário criado com sucesso!",
                "data", usuarioSalvo,
                "timestamp", System.currentTimeMillis()
            ));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                "success", false,
                "message", "Falha ao criar usuário",
                "error", e.getMessage(),
                "timestamp", System.currentTimeMillis()
            ));
        }
    }

    // ✅ LISTAR TODOS OS USUÁRIOS
    @GetMapping
    public ResponseEntity<Map<String, Object>> listarUsuarios() {
        try {
            List<UsuarioModel> usuarios = usuarioService.listarTodos();
            
            return ResponseEntity.ok(Map.of(
                "success", true,
                "message", usuarios.isEmpty() ? "Nenhum usuário encontrado" : "Usuários listados com sucesso",
                "data", usuarios,
                "total", usuarios.size(),
                "timestamp", System.currentTimeMillis()
            ));
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "success", false,
                "message", "Erro ao listar usuários",
                "error", e.getMessage(),
                "timestamp", System.currentTimeMillis()
            ));
        }
    }

    // ✅ BUSCAR USUÁRIO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> buscarUsuarioPorId(@PathVariable Long id) {
        try {
            Optional<UsuarioModel> usuario = usuarioService.buscarPorId(id);
            
            if (usuario.isPresent()) {
                return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "Usuário encontrado com sucesso",
                    "data", usuario.get(),
                    "timestamp", System.currentTimeMillis()
                ));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                    "success", false,
                    "message", "Usuário não encontrado",
                    "id", id,
                    "timestamp", System.currentTimeMillis()
                ));
            }
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "success", false,
                "message", "Erro ao buscar usuário",
                "error", e.getMessage(),
                "timestamp", System.currentTimeMillis()
            ));
        }
    }

    // ✅ BUSCAR USUÁRIOS POR NOME
    @GetMapping("/buscar")
    public ResponseEntity<Map<String, Object>> buscarPorNome(@RequestParam String nome) {
        try {
            List<UsuarioModel> usuarios = usuarioService.buscarPorNome(nome);
            
            return ResponseEntity.ok(Map.of(
                "success", true,
                "message", usuarios.isEmpty() ? "Nenhum usuário encontrado" : "Busca realizada com sucesso",
                "data", usuarios,
                "termo_busca", nome,
                "total_encontrado", usuarios.size(),
                "timestamp", System.currentTimeMillis()
            ));
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "success", false,
                "message", "Erro na busca",
                "error", e.getMessage(),
                "timestamp", System.currentTimeMillis()
            ));
        }
    }

    // ✅ ATUALIZAR USUÁRIO
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizarUsuario(
            @PathVariable Long id, 
            @Valid @RequestBody UsuarioModel usuario) {
        try {
            UsuarioModel usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);
            
            return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "Usuário atualizado com sucesso!",
                "data", usuarioAtualizado,
                "id", id,
                "timestamp", System.currentTimeMillis()
            ));
            
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                "success", false,
                "message", "Usuário não encontrado para atualização",
                "id", id,
                "error", e.getMessage(),
                "timestamp", System.currentTimeMillis()
            ));
        }
    }

    // ✅ DELETAR USUÁRIO
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletarUsuario(@PathVariable Long id) {
        try {
            usuarioService.deletarUsuario(id);
            
            return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "Usuário deletado com sucesso!",
                "id", id,
                "timestamp", System.currentTimeMillis()
            ));
            
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                "success", false,
                "message", "Usuário não encontrado para exclusão",
                "id", id,
                "error", e.getMessage(),
                "timestamp", System.currentTimeMillis()
            ));
        }
    }

    // ✅ VERIFICAR SE EMAIL EXISTE
    @GetMapping("/verificar-email/{email}")
    public ResponseEntity<Map<String, Object>> verificarEmail(@PathVariable String email) {
        try {
            boolean existe = usuarioService.emailExiste(email);
            
            return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "Verificação de email realizada",
                "email", email,
                "disponivel", !existe,
                "sugestao", existe ? "Este email já está em uso" : "Email disponível para cadastro",
                "timestamp", System.currentTimeMillis()
            ));
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "success", false,
                "message", "Erro ao verificar email",
                "error", e.getMessage(),
                "timestamp", System.currentTimeMillis()
            ));
        }
    }

    // ✅ CONTAR TOTAL DE USUÁRIOS
    @GetMapping("/contar")
    public ResponseEntity<Map<String, Object>> contarUsuarios() {
        try {
            long total = usuarioService.contarUsuarios();
            
            return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "Contagem de usuários realizada",
                "total_usuarios", total,
                "status", total > 0 ? "Sistema com usuários cadastrados" : "Sistema sem usuários",
                "timestamp", System.currentTimeMillis()
            ));
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "success", false,
                "message", "Erro ao contar usuários",
                "error", e.getMessage(),
                "timestamp", System.currentTimeMillis()
            ));
        }
    }

    // ✅ ENDPOINT DE BOAS-VINDAS
    @GetMapping("/bem-vindo")
    public ResponseEntity<Map<String, Object>> bemVindo() {
        return ResponseEntity.ok(Map.of(
            "success", true,
            "message", "Bem vindo à API de Usuários! 🚀",
            "versao", "1.0.0",
            "descricao", "Sistema completo de gerenciamento de usuários",
            "endpoints_disponiveis", List.of(
                "POST /api/usuarios - Criar usuário",
                "GET /api/usuarios - Listar todos",
                "GET /api/usuarios/{id} - Buscar por ID",
                "PUT /api/usuarios/{id} - Atualizar usuário",
                "DELETE /api/usuarios/{id} - Deletar usuário"
            ),
            "timestamp", System.currentTimeMillis()
        ));
    }

    // ✅ HEALTH CHECK
    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> healthCheck() {
        return ResponseEntity.ok(Map.of(
            "status", "UP",
            "service", "Usuario API",
            "timestamp", System.currentTimeMillis(),
            "message", "Serviço funcionando normalmente ✅"
        ));
    }
}