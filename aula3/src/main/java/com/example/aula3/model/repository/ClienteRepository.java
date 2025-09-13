package com.example.aula3.model.repository;

import com.example.aula3.model.Cliente;  // <-- Import da entidade Cliente
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Aqui você pode adicionar métodos customizados, se precisar
}
