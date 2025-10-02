package com.example.aula7.repository;

import com.example.aula7.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    
    Optional<Usuario> findByEmail(String email);
    
    List<Usuario> findByIdadeGreaterThan(Integer idade);
    
    List<Usuario> findByNomeContainingIgnoreCase(String nome);
    
    boolean existsByEmail(String email);
}