package com.agendaJogos.models;
import java.time.LocalTime;
import java.util.Date;

public class Jogo {
    private Integer id_jogo;
    private String time_casa;
    private String time_visitante;
    private Date data;
    private LocalTime horario;
    private String local;

    public Jogo() {
    }


    public Integer getId_jogo() {
        return id_jogo;
    }

    public void setId_jogo(Integer id_jogo) {
        this.id_jogo = id_jogo;
    }

    public String getTime_casa() {
        return time_casa;
    }

    public void setTime_casa(String time_casa) {
        this.time_casa = time_casa;
    }

    public String getTime_visitante() {
        return time_visitante;
    }

    public void setTime_visitante(String time_visitante) {
        this.time_visitante = time_visitante;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
    public void setLocal(String local) {
        this.local = local;
    }

    public String getLocal(){
        return local;
    }
}

