package com.example.vitapet.clinic.controller;

import com.example.vitapet.clinic.model.Animal;
import com.example.vitapet.clinic.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> getAllAnimais() {
        return animalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
        Optional<Animal> animal = animalService.findById(id);
        return animal.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.save(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animalDetails) {
        Optional<Animal> animal = animalService.findById(id);

        if (animal.isPresent()) {
            Animal updatedAnimal = animal.get();
            updatedAnimal.setNome(animalDetails.getNome());
            updatedAnimal.setRaca(animalDetails.getRaca());
            updatedAnimal.setIdade(animalDetails.getIdade());
            updatedAnimal.setPeso(animalDetails.getPeso());
            updatedAnimal.setObservacoes(animalDetails.getObservacoes());

            return ResponseEntity.ok(animalService.save(updatedAnimal));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        if (animalService.findById(id).isPresent()) {
            animalService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tutor/{tutorId}")
    public List<Animal> getAnimaisByTutor(@PathVariable Long tutorId) {
        return animalService.findByTutorId(tutorId);
    }
}
