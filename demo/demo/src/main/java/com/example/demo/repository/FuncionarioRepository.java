package com.example.demo.repository;

import com.example.demo.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {
    Optional<Funcionario> findByCpf(String cpf);
    Optional<Funcionario> findByMatricula(String matricula);
    boolean existsByCpf(String cpf);
    boolean existsByMatricula(String matricula);
}