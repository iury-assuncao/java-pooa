package com.agendaJogos.dao.impl;

import com.agendaJogos.dto.IngressoDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngressoDetailsRowMapper implements RowMapper<IngressoDTO> {

    @Override
    public IngressoDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        IngressoDTO ingressoDetailsDTO = new IngressoDTO();
        ingressoDetailsDTO.setIdIngresso(resultSet.getInt("id_ingresso"));
        ingressoDetailsDTO.setNomeTorcedor(resultSet.getString("nome_torcedor"));
        ingressoDetailsDTO.setTimeCasa(resultSet.getString("time_casa"));
        ingressoDetailsDTO.setTimeVisitante(resultSet.getString("time_visitante"));
        ingressoDetailsDTO.setLocal(resultSet.getString("local"));
        ingressoDetailsDTO.setData(resultSet.getString("data"));
        ingressoDetailsDTO.setHorario(resultSet.getString("horario"));

        return ingressoDetailsDTO;
    }
}
