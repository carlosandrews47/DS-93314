package com.example.vitapet.clinic.model;

import com.example.vitapet.clinic.enums.CargoFuncionarioEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

/**
 * Entidade que representa um funcionário da clínica.
 */
@Entity
@Getter
@Setter
public class Funcionario extends Pessoa {

    @Enumerated(EnumType.STRING)
    private CargoFuncionarioEnum cargo;

    private String especialidade;

    private String crmv;

    private Double salario;

    // Usar LocalDate é melhor para persistência
    private LocalDate dataAdmissao;
}