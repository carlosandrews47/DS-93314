package com.example.AULA9.repository;

import com.example.AULA9.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
    Optional<FuncionarioModel> findByEmail(String email);
    List<FuncionarioModel> findByCargo(String cargo);
    List<FuncionarioModel> findByNomeContainingIgnoreCase(String nome);
}