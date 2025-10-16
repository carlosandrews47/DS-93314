package com.example.aula14.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Wellcome {

    @GetMapping("/")
    public String mensagem() {
        return "Bem-vindo à aplicação!";
    }
}
