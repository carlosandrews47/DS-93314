package com.example.aula8.repository;

import com.example.aula8.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    
    Optional<UsuarioModel> findByEmail(String email);
    boolean existsByEmail(String email);
    List<UsuarioModel> findByNomeContainingIgnoreCase(String nome);
}