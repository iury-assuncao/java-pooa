package com.agendaJogos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/jogo")
public class JogoController {

    @GetMapping
    public ResponseEntity getAllFans(){
        return ResponseEntity.ok("Jogo deu bom!");

    }
}
