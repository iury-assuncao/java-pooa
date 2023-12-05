package com.agendaJogos.dao.impl;

import com.agendaJogos.models.Ingresso;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngressoRowMapper implements RowMapper<Ingresso> {

    @Override
    public Ingresso mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Ingresso ingresso = new Ingresso();
        ingresso.setId_ingresso(resultSet.getInt("id_ingresso"));
        ingresso.setId_torcedor(resultSet.getInt("id_torcedor"));
        ingresso.setId_jogo(resultSet.getInt("id_jogo"));

        return ingresso;
    }
}