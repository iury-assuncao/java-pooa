package com.agendaJogos.models;


public class Torcedor {
    private Integer  id_torcedor;
    private String nome;
    private String telefone;
    private String email;


    public Integer  getId_torcedor() {
        return id_torcedor;
    }

    public void setId_torcedor(Integer  id_torcedor) {
        this.id_torcedor = id_torcedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}