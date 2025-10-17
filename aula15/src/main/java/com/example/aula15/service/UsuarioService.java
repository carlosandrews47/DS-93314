package com.example.aula15.service;

import com.example.aula15.dto.UsuarioRequestDTO;
import com.example.aula15.model.UsuarioModel;
import com.example.aula15.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Salva um novo usuario
    public UsuarioModel salvarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        // Verificando se o email já existe no banco de dados
        if (usuarioRepository.findByEmail(usuarioRequestDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }

        UsuarioModel novoUsuario = new UsuarioModel();
        novoUsuario.setNome(usuarioRequestDTO.getNome());
        novoUsuario.setEmail(usuarioRequestDTO.getEmail());
        // Criptografando a senha antes de salvar
        novoUsuario.setSenha(passwordEncoder.encode(usuarioRequestDTO.getSenha()));

        usuarioRepository.save(novoUsuario);
        return novoUsuario;
    }

    // Buscar todos os usuários
    public List<UsuarioModel> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    // Buscar usuário por ID
    public UsuarioModel buscarUsuarioPorId(Long id) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }
        return usuario.get();
    }

    // Update
    public UsuarioModel atualizarUsuario(Long id, UsuarioRequestDTO dto) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado.");
        }

        UsuarioModel atualizarUsuario = new UsuarioModel();
        atualizarUsuario.setId(id);
        atualizarUsuario.setNome(dto.getNome());
        atualizarUsuario.setEmail(dto.getEmail());
        // Criptografando a senha antes de salvar
        atualizarUsuario.setSenha(passwordEncoder.encode(dto.getSenha()));

        usuarioRepository.save(atualizarUsuario);
        return atualizarUsuario;
    }

    // Delete
    public void excluirUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado.");
        }
        usuarioRepository.deleteById(id);
    }
}