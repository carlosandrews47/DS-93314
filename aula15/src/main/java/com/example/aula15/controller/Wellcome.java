package com.example.aula15.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Wellcome {

    @GetMapping("/")
    public String mensagen() {
        return "Bem vindo";
    }

    @GetMapping("/dev")
    public String dev() {
        return "desenvolvimeto (a): carlos andre";
    }
}
