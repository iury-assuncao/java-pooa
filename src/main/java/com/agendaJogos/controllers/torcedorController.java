package com.agendaJogos.controllers;

import com.agendaJogos.dao.TorcedorDao;
import com.agendaJogos.models.Torcedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/torcedor")
public class torcedorController {

    private TorcedorDao torcedorDao;

    @Autowired
    public torcedorController(TorcedorDao torcedorDao){
        this.torcedorDao = torcedorDao;
    }

    @GetMapping
    public ResponseEntity getAllTorcedores(){
        List<Torcedor> torcedores = torcedorDao.findAll();
        return ResponseEntity.ok(torcedores);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Torcedor> getTorcedorById(@PathVariable Integer id) {
        try {
            Torcedor torcedor = torcedorDao.findById(id);
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
            torcedorDao.save(torcedor);
            return new ResponseEntity<>("Torcedor criado com sucesso", HttpStatus.CREATED);

        } catch (Exception e){
            return new ResponseEntity<>("Erro de ao criar torcedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTorcedor(@PathVariable Integer id, @RequestBody Torcedor torcedor) {
        try {
            if (torcedorDao.findById(id) != null) {
                torcedorDao.update(torcedor);
                return new ResponseEntity<>("Torcedor foi atualizado com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Torcedor não encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar torcedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTorcedor(@PathVariable Integer id) {
        try{
            if (torcedorDao.findById(id) != null) {
                torcedorDao.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);


        }


    }
}
