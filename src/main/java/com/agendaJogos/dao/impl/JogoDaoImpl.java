package com.agendaJogos.dao.impl;

import com.agendaJogos.dao.JogoDao;
import com.agendaJogos.models.Jogo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JogoDaoImpl implements JogoDao {

    private final JdbcTemplate jdbcTemplate;

    public JogoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Jogo findById(String id) {
        String sql = "";
        return null;
    }

    @Override
    public List<Jogo> findAll() {
        return null;
    }

    @Override
    public void save(Jogo user) {

    }

    @Override
    public void update(Jogo user) {

    }

    @Override
    public void delete(String id) {

    }
}
