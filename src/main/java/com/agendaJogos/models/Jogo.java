package com.agendaJogos.models;
import java.time.LocalTime;
import java.util.Date;

public class Jogo {
    private String id_jogo;
    private String time_casa;
    private String time_visitante;
    private Date data;
    private LocalTime horario;

    public Jogo(String time_casa, String time_visitante, Date data, LocalTime horario){
        this.time_casa = time_casa;
        this.time_visitante = time_visitante;
        this.data = data;
        this.horario = horario;

    }

    public String getId_jogo() {
        return id_jogo;
    }

    public void setId_jogo(String id_jogo) {
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
}
