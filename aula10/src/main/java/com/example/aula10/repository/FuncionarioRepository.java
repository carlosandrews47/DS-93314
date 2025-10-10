package com.example.aula10.repository;


import com.example.aula10.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByEmail(String email);
    Optional<Funcionario> findByMatricula(String matricula);
    boolean existsByEmail(String email);
    boolean existsByMatricula(String matricula);
}
