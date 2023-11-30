package com.agendaJogos.dao;


import com.agendaJogos.models.Torcedor;

import java.util.List;

public interface TorcedorDao {
    Torcedor findById(Integer id);
    List<Torcedor> findAll();
    void save(Torcedor user);
    Torcedor update(Torcedor user, Integer id);
    void delete(Integer id);
}
