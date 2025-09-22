package com.example.vitapet.clinic.repository;

import com.example.vitapet.clinic.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByTutorId(Long tutorId);
    List<Animal> findByNomeContainingIgnoreCase(String nome);
}
