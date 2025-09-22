package com.example.vitapet.clinic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataRegistro;
    private String historico;
    private String medicamentos;
    private String vacinas;
    private String alergias;
    private String cirurgias;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
}
