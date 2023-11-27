package com.agendaJogos.dao;

import com.agendaJogos.models.Jogo;

import java.util.List;

public interface JogoDao {
    Jogo findById(String id);

    List<Jogo> findAll();
    void save(Jogo user);
    void update(Jogo user);
    void delete(String id);
}
