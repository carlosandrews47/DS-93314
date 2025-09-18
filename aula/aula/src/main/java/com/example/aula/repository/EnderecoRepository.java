package com.example.aula.repository;

import com.example.aula.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {

    List<Endereco> findByLogradouroContainingIgnoreCase(String logradouro);
    List<Endereco> findByNumero(String numero);
    Optional<Endereco> findByLogradouroAndNumero(String logradouro, String numero);
    boolean existsByLogradouro(String logradouro);
}
