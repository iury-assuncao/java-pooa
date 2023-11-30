package com.agendaJogos.dao.impl;

import com.agendaJogos.dao.JogoDao;
import com.agendaJogos.models.Jogo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class JogoDaoImpl implements JogoDao {

    private final JdbcTemplate jdbcTemplate;

    public JogoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Jogo findById(Integer id) {
        String query = "SELECT * FROM jogos WHERE id_jogo=?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{id}, new JogoRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Jogo> findAll() {
        String query = "SELECT * FROM jogos";
        try {
            return jdbcTemplate.query(query, new JogoRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void save(Jogo jogo) {
        String query = "INSERT INTO jogos(time_casa, time_visitante, data, horario, local) VALUES (?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(query, jogo.getTime_casa(), jogo.getTime_visitante(), jogo.getData(), jogo.getHorario(), jogo.getLocal());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Jogo jogo, Integer id) {
        String query = "UPDATE jogos SET time_casa=?, time_visitante=?, data=?, horario=?, local=? WHERE id_jogo=?";
        try {
            jdbcTemplate.update(query, jogo.getTime_casa(), jogo.getTime_visitante(), jogo.getData(), jogo.getHorario(), jogo.getLocal(), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Override
    public void delete(Integer id) {
       String query = "DELETE FROM jogos WHERE id_jogo=?";
       try{
           jdbcTemplate.update(query,id);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
