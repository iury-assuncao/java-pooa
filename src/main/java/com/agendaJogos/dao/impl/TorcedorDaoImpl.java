package com.agendaJogos.dao.impl;

import com.agendaJogos.dao.TorcedorDao;
import com.agendaJogos.models.Torcedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class TorcedorDaoImpl implements TorcedorDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TorcedorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }
    @Override
    public Torcedor findById(Integer id) {
        String query = "SELECT * FROM torcedores WHERE id_torcedor=?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{id}, new TorcedorRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Torcedor> findAll() {
        String query = "SELECT * FROM torcedores";
        try {
            return jdbcTemplate.query(query, new TorcedorRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    @Override
    public void save(Torcedor torcedor) {
        String query = "INSERT INTO torcedores(nome, telefone, email) VALUES (?, ?, ?)";
        try {
            jdbcTemplate.update(query, torcedor.getNome(), torcedor.getTelefone(), torcedor.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Torcedor update(Torcedor torcedor, Integer id) {
        String query = "UPDATE torcedores SET nome = ?, telefone = ?, email = ? WHERE id_torcedor = ?";
        try {
            jdbcTemplate.update(query, torcedor.getNome(), torcedor.getTelefone(), torcedor.getEmail(), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return torcedor;
    }

    @Override
    public void delete(Integer id) {
        String query = "DELETE FROM torcedores WHERE id_torcedor=?";
        try {
            jdbcTemplate.update(query, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
