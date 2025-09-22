package com.example.vitapet.clinic.model;


import com.example.vitapet.clinic.enums.TipoInternacaoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Internacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;

    @Enumerated(EnumType.STRING)
    private TipoInternacaoEnum tipoInternacao;

    private String observacoes;
    private Double valorDiaria;
    private Integer diasInternacao;

    @OneToOne(mappedBy = "internacao")
    private Atendimento atendimento;

    public Double getValorTotal() {
        return valorDiaria * diasInternacao;
    }
}