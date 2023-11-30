package com.agendaJogos.dao.impl;
import com.agendaJogos.models.Jogo;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JogoRowMapper implements RowMapper<Jogo> {

    @Override
    public Jogo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Jogo jogo = new Jogo();
        jogo.setId_jogo(resultSet.getInt("id_jogo"));
        jogo.setTime_casa(resultSet.getString("time_casa"));
        jogo.setTime_visitante(resultSet.getString("time_visitante"));
        jogo.setHorario(resultSet.getTime("horario").toLocalTime());
        jogo.setLocal((resultSet.getString("local")));
        jogo.setData(resultSet.getDate("data"));
        return jogo;
    }
}
