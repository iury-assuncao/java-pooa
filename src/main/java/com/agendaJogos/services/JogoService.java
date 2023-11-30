package com.agendaJogos.services;

import com.agendaJogos.dao.JogoDao;
import com.agendaJogos.models.Jogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    private final JogoDao jogoDao;

    @Autowired
    public JogoService(JogoDao jogoDao) {
        this.jogoDao = jogoDao;
    }

    public Jogo getJogoById(Integer id) {
        return jogoDao.findById(id);
    }

    public List<Jogo> getAllJogos() {
        return jogoDao.findAll();
    }

    public void createJogo(Jogo jogo) {
        jogoDao.save(jogo);
    }

    public void updateJogo(Jogo jogo, Integer id) {
        jogoDao.update(jogo, id);
    }

    public void deleteJogo(Integer id) {
        jogoDao.delete(id);
    }
}
