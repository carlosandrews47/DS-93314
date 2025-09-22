package com.example.vitapet.clinic.model;

import com.example.vitapet.clinic.enums.TipoServicoEnum;
import com.example.vitapet.clinic.enums.StatusServicoEnum; // <-- IMPORT NECESSÁRIO
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoServicoEnum tipo;

    private String descricao;
    private LocalDateTime dataAgendamento;
    private Double valor;

    @Enumerated(EnumType.STRING)
    private StatusServicoEnum status;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
}
