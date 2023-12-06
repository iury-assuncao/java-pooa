package com.agendaJogos.services;

import com.agendaJogos.dao.IngressoDao;
import com.agendaJogos.dto.IngressoDTO;
import com.agendaJogos.models.Ingresso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class IngressoService {

    private final IngressoDao ingressoDao;

    @Autowired
    public IngressoService(IngressoDao ingressoDao) {
        this.ingressoDao = ingressoDao;
    }


    public void saveIngresso(Ingresso ingresso) {
        ingressoDao.save(ingresso);
    }

    public void updateIngresso(Ingresso ingresso) {
        ingressoDao.update(ingresso);
    }

    public void deleteIngresso(Integer id_ingresso) {
        ingressoDao.delete(id_ingresso);
    }

    public Ingresso findIngressoById(Integer id_ingresso) {
        return ingressoDao.findById(id_ingresso);
    }

    public List<Ingresso> findAllIngressos() {
        return ingressoDao.findAll();
    }

    public List<IngressoDTO> getAllIngressosWithDetails() {
        return ingressoDao.getAllIngressosWithDetails();
    }
}
