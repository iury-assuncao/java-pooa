package com.agendaJogos.dao;

import com.agendaJogos.models.Jogo;

import java.util.List;

public interface JogoDao {
    Jogo findById(Integer id);

    List<Jogo> findAll();
    void save(Jogo user);
    void update(Jogo user, Integer id);


    void delete(Integer id);
}
