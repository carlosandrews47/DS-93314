package com.example.aula8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Welcome {

    
    @GetMapping("/")
    public String welcome() {
        return "Bem vindo ao spring boot";
    }
}
