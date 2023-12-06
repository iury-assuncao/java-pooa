package com.agendaJogos.dao.impl;

import com.agendaJogos.dao.IngressoDao;
import com.agendaJogos.dto.IngressoDTO;
import com.agendaJogos.models.Ingresso;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IngressoDaoImpl implements IngressoDao {

    private final JdbcTemplate jdbcTemplate;

    public IngressoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Ingresso ingresso) {
        String query = "INSERT INTO ingressos(id_torcedor, id_jogo) VALUES (?, ?)";
        try {
            jdbcTemplate.update(query, ingresso.getId_torcedor(), ingresso.getId_jogo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Ingresso ingresso) {
        String query = "UPDATE ingressos SET id_torcedor = ?, id_jogo = ? WHERE id_ingresso = ?";
        try {
            jdbcTemplate.update(query, ingresso.getId_torcedor(), ingresso.getId_jogo(), ingresso.getId_ingresso());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String query = "DELETE FROM ingressos WHERE id_ingresso=?";
        try {
            jdbcTemplate.update(query, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ingresso findById(Integer id) {
        String query = "SELECT * FROM ingressos WHERE id_ingresso=?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{id}, new IngressoRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Ingresso> findAll() {
        String query = "SELECT * FROM ingressos";
        return jdbcTemplate.query(query, new IngressoRowMapper());
    }

    @Override
    public List<IngressoDTO> getAllIngressosWithDetails() {
        String query = "SELECT ingressos.id_ingresso, torcedores.nome AS nome_torcedor, torcedores.email AS email_torcedor, jogos.time_casa, jogos.time_visitante, jogos.local, jogos.data, jogos.horario FROM ingressos JOIN torcedores ON ingressos.id_torcedor = torcedores.id_torcedor JOIN jogos ON ingressos.id_jogo = jogos.id_jogo";

        return jdbcTemplate.query(query, new IngressoDetailsRowMapper());
    }
}
