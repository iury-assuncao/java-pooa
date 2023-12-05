package com.agendaJogos.dao;

import com.agendaJogos.dto.IngressoDTO;
import com.agendaJogos.models.Ingresso;

import java.util.List;

public interface IngressoDao {
    void save(Ingresso ingresso);

    void update(Ingresso ingresso);

    void delete(Integer id_ingresso);

    Ingresso findById(Integer id_ingresso);

    List<Ingresso> findAll();

    List<IngressoDTO> getAllIngressosWithDetails();

}

