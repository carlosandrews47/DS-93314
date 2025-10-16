package com.example.aula14.service;

import com.example.aula14.dto.UsuarioRequestDTO;
import com.example.aula14.model.UsuarioModel;
import com.example.aula14.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // Salvar.
    public UsuarioModel salvarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        if (usuarioRepository.findByEmail(usuarioRequestDTO.getEmail()).isPresent())
            throw new IllegalArgumentException("Usuario já cadastrado.");

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        // Criptografia da senha antes de salvar no banco de dados.
        usuario.setSenha(bCryptPasswordEncoder.encode(usuarioRequestDTO.getSenha()));
        usuario.setIdade(usuarioRequestDTO.getIdade()); // ADICIONAR ESTA LINHA
        usuario.setAtivo(true); // ADICIONAR ESTA LINHA
        usuarioRepository.save(usuario);
        return usuario;
    }
}