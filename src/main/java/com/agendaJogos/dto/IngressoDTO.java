package com.agendaJogos.dto;

public class IngressoDTO {
    private Integer idIngresso;
    private String nomeTorcedor;
    private String timeCasa;
    private String timeVisitante;
    private String local;
    private String data;
    private String horario;


    public String getNomeTorcedor() {
        return nomeTorcedor;
    }

    public void setNomeTorcedor(String nomeTorcedor) {
        this.nomeTorcedor = nomeTorcedor;
    }

    public String getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(String timeCasa) {
        this.timeCasa = timeCasa;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(String timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(Integer idIngresso) {
        this.idIngresso = idIngresso;
    }
}