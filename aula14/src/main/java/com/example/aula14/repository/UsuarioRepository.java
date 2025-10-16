package com.example.aula14.repository;

import com.example.aula14.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByEmail(String email);
    boolean existsByEmail(String email);
    List<UsuarioModel> findByAtivoTrue();
    List<UsuarioModel> findByNomeContainingIgnoreCase(String nome);
    boolean existsById(Long id);
}