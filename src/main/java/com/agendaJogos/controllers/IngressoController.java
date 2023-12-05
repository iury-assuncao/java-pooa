package com.agendaJogos.controllers;

import com.agendaJogos.dto.IngressoDTO;
import com.agendaJogos.models.Ingresso;
import com.agendaJogos.services.IngressoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {

    private final IngressoService ingressoService;

    @Autowired
    public IngressoController(IngressoService ingressoService) {
        this.ingressoService = ingressoService;
    }

    @PostMapping
    public ResponseEntity<String> createIngresso(@RequestBody Ingresso ingresso) {
        try {
            ingressoService.save(ingresso);
            return new ResponseEntity<>("Ingresso criado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar ingresso", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingresso> getIngressoById(@PathVariable Integer id) {
        try {
            Ingresso ingresso = ingressoService.findById(id);
            if (ingresso != null) {
                return new ResponseEntity<>(ingresso, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity getAllIngressos() {
        try {
            List<Ingresso> ingressos = ingressoService.findAll();
            return new ResponseEntity<>(ingressos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/details")
    public ResponseEntity<List<IngressoDTO>> getAllIngressosWithDetails() {
        try {
            List<IngressoDTO> ingressos = ingressoService.getAllIngressosWithDetails();
            return new ResponseEntity<>(ingressos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
