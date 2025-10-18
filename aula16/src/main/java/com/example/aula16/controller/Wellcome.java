package com.example.aula16.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Wellcome {

    @GetMapping
    public String mensagen() {
        return "Bem vindo ao sistema Aula16!";
    }
}
