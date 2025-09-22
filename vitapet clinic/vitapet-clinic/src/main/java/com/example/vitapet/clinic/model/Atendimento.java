package com.example.vitapet.clinic.model;

import com.example.vitapet.clinic.enums.FormaPagamentoEnum;
import com.example.vitapet.clinic.enums.TipoAtendimentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * Entidade que representa um atendimento veterinário.
 */
@Entity
@Getter
@Setter
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private TipoAtendimentoEnum tipoAtendimento;

    @Enumerated(EnumType.STRING)
    private FormaPagamentoEnum formaPagamento;

    private String numeroCarteiraPlano;
    private String nomePlanoSaude;

    private String diagnostico;
    private String procedimentosRealizados;
    private String medicamentosPrescritos;
    private Double valorConsulta;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Funcionario veterinario;

    @OneToOne
    @JoinColumn(name = "internacao_id")
    private Internacao internacao;
}