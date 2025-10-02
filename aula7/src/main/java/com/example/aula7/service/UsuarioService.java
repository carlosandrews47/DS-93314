package com.example.aula7.service;
import com.example.aula7.model.Usuario;
import com.example.aula7.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario salvarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email já está em uso: " + usuario.getEmail());
        }
        return usuarioRepository.save(usuario);
    }
    
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
    
    public Optional<Usuario> buscarPorId(UUID id) {
        return usuarioRepository.findById(id);
    }
    
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    
    public Optional<Usuario> atualizarUsuario(UUID id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id)
                .map(usuarioExistente -> {
                    if (!usuarioExistente.getEmail().equals(usuarioAtualizado.getEmail()) &&
                        usuarioRepository.existsByEmail(usuarioAtualizado.getEmail())) {
                        throw new RuntimeException("Email já está em uso: " + usuarioAtualizado.getEmail());
                    }
                    
                    usuarioExistente.setNome(usuarioAtualizado.getNome());
                    usuarioExistente.setEmail(usuarioAtualizado.getEmail());
                    usuarioExistente.setIdade(usuarioAtualizado.getIdade());
                    
                    return usuarioRepository.save(usuarioExistente);
                });
    }
    
    public boolean deletarUsuario(UUID id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<Usuario> buscarPorIdadeMaiorQue(Integer idade) {
        return usuarioRepository.findByIdadeGreaterThan(idade);
    }
    
    public List<Usuario> buscarPorNome(String nome) {
        return usuarioRepository.findByNomeContainingIgnoreCase(nome);
    }
}