package com.agendaJogos.dao;


import com.agendaJogos.models.Torcedor;

import java.util.List;

public interface TorcedorDao {
    Torcedor findById(Integer id);
    List<Torcedor> findAll();
    void save(Torcedor user);
    void update(Torcedor user);
    void delete(Integer id);
}
