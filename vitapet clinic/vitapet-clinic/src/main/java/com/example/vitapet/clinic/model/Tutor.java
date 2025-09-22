package com.example.vitapet.clinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Tutor extends Pessoa {
    @OneToMany(mappedBy = "tutor")
    private List<Animal> animais;
}
