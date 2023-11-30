package com.agendaJogos.controllers;

import com.agendaJogos.models.Jogo;
import com.agendaJogos.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoService jogoService;

    @Autowired
    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> getJogoById(@PathVariable Integer id) {
        try {
            Jogo jogo = jogoService.getJogoById(id);
            if (jogo != null) {
                return new ResponseEntity<>(jogo, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> getAllJogos() {
        try {
            List<Jogo> jogos = jogoService.getAllJogos();
            return new ResponseEntity<>(jogos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<String> createJogo(@RequestBody Jogo jogo) {
        try {
            jogoService.createJogo(jogo);
            return new ResponseEntity<>("Jogo criado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar jogo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJogo(@PathVariable Integer id, @RequestBody Jogo jogo) {
        try {
            if (jogoService.getJogoById(id) != null) {
                jogoService.updateJogo(jogo, id);
                return new ResponseEntity<>("Jogo foi atualizado com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Jogo não encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar jogo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJogo(@PathVariable Integer id) {
        try {
            jogoService.deleteJogo(id);
            return new ResponseEntity<>("Jogo foi excluído com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao excluir jogo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
