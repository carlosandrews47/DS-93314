package com.example.aula.repository;

import com.example.aula.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Buscar cliente por email
    Optional<Cliente> findByEmail(String email);

    // Buscar clientes por nome (case insensitive)
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    // Verificar se existe cliente com email
    boolean existsByEmail(String email);
}