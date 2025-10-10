package com.example.aula10.controller;





import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Wellcome {

    @GetMapping("/carlos")
    public String wellcome() {
        return "API de Cadastro está funcionando! ";
    }
}
