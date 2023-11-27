package com.agendaJogos.dao.impl;

import com.agendaJogos.models.Torcedor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TorcedorRowMapper implements RowMapper<Torcedor> {

    @Override
    public Torcedor mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Torcedor torcedor = new Torcedor();
        torcedor.setId_torcedor(resultSet.getInt("id_torcedor"));
        torcedor.setNome(resultSet.getString("nome"));
        torcedor.setTelefone(resultSet.getString("telefone"));
        torcedor.setEmail(resultSet.getString("email"));
        return torcedor;
    }
}
