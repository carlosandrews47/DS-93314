package com.example.Projeto_senai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/senai")

public class Welcome {


    @GetMapping("/")
    public String mensagem() {
        return " Bem Vindo!";
    }

    @GetMapping("/dev")
    public String dev() {
        return " carlos Andre!";


    }

    @GetMapping("/dev/aula")
    public String devAula() {
        return " Aula!";

    }

    @GetMapping("/dev/sala")
    public String devSala() {
        return " Sala!";

    }

    @GetMapping("/dev/aluno")
    public String devAluno() {
        return " Aluno!";

    }

}