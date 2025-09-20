package com.example.aula5.repository;

import com.example.aula5.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    // Método personalizado para buscar por telefone
    // O Spring Data JPA vai implementar automaticamente
    Optional<Cliente> findByTelefone(String telefone);

    // Método personalizado para verificar existência por telefone
    boolean existsByTelefone(String telefone);

    // Método personalizado para buscar por nome (exato)
    Optional<Cliente> findByNome(String nome);

    // Método personalizado para buscar por parte do nome
    List<Cliente> findByNomeContaining(String nome);

    // Consulta personalizada com JPQL
    @Query("SELECT c FROM Cliente c WHERE c.telefone = :telefone")
    Optional<Cliente> buscarPorTelefone(@Param("telefone") String telefone);

    // Consulta personalizada com JPQL para buscar por parte do nome
    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Cliente> buscarPorParteDoNome(@Param("nome") String nome);
}