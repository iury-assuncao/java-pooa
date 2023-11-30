package com.agendaJogos.services;

import com.agendaJogos.dao.TorcedorDao;
import com.agendaJogos.models.Torcedor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorcedorService {

    private final TorcedorDao torcedorDao;

    public TorcedorService(TorcedorDao torcedorDao) {
        this.torcedorDao = torcedorDao;
    }

    public Torcedor getTorcedorById(Integer id){
        return torcedorDao.findById(id);
    }
    public List<Torcedor> getAllTorcedores() {
        return torcedorDao.findAll();
    }

    public void createTorcedor(Torcedor torcedor) {
        torcedorDao.save(torcedor);
    }

    public Torcedor updateTorcedor(Torcedor torcedor, Integer id){
        return  torcedorDao.update(torcedor, id);
    }

    public void deleteTorcedor(Integer id) {
        torcedorDao.delete(id);
    }


}
