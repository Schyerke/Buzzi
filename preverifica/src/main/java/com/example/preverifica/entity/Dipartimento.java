package com.example.preverifica.entity;

public class Dipartimento {
    private int id;
    private String descrizione;

    public Dipartimento() {

    }
    public Dipartimento(String descrizione) {
        this.descrizione = descrizione;
    }

    public Dipartimento(int id, String descrizione) {
        this.id = id;
        this.descrizione = descrizione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Dipartimento: " +
                "id=" + id +
                ", descrizione='" + descrizione + '\'';
    }
}
