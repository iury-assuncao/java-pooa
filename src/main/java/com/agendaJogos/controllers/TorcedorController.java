package com.agendaJogos.controllers;

import com.agendaJogos.models.Torcedor;
import com.agendaJogos.services.TorcedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/torcedor")
public class TorcedorController {

    private TorcedorService torcedorService;

    @Autowired
    public TorcedorController(TorcedorService torcedorService){
        this.torcedorService = torcedorService;
    }

    @GetMapping
    public ResponseEntity getAllTorcedores(){
        List<Torcedor> torcedores = torcedorService.getAllTorcedores();
        return ResponseEntity.ok(torcedores);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Torcedor> getTorcedorById(@PathVariable Integer id) {
        try {
            Torcedor torcedor = torcedorService.getTorcedorById(id);
            if (torcedor != null) {
                return new ResponseEntity<>(torcedor, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<String> createTorcedor(@RequestBody Torcedor torcedor) {
        try{
            torcedorService.createTorcedor(torcedor);
            return new ResponseEntity<>("Torcedor cadastrado com sucesso", HttpStatus.CREATED);

        } catch (Exception e){
            return new ResponseEntity<>("Erro de ao criar torcedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTorcedor(@PathVariable Integer id, @RequestBody Torcedor torcedor) {
        try {
            if (torcedorService.getTorcedorById(id) != null) {
                torcedorService.updateTorcedor(torcedor, id);

                return new ResponseEntity<>("Torcedor foi atualizado com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Torcedor não encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar torcedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTorcedor(@PathVariable Integer id) {
        try{
            if (torcedorService.getTorcedorById(id) != null) {
                torcedorService.deleteTorcedor(id);
                return new ResponseEntity<>("Torcedor deletado com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Torcedor não encontrado",HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>("Erro ao deletar torcedor",HttpStatus.INTERNAL_SERVER_ERROR);


        }


    }
}
