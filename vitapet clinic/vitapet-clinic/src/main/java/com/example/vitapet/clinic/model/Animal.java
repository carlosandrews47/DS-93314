package com.example.vitapet.clinic.model;

import com.example.vitapet.clinic.enums.SexoAnimalEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Restrição a nível de banco de dados
    private String nome;

    private String raca;
    private Integer idade;
    private Double peso;

    @Enumerated(EnumType.STRING)
    private SexoAnimalEnum sexo;

    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prontuario> prontuarios;
}