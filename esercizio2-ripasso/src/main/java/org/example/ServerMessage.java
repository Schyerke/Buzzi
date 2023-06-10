package org.example;

public class ServerMessage {
    private int scelta;
    private String id;
    private int quantita;

    public ServerMessage() {

    }

    public ServerMessage(int scelta, String id, int quantita) {
        this.scelta = scelta;
        this.id = id;
        this.quantita = quantita;
    }

    public int getScelta() {
        return scelta;
    }

    public void setScelta(int scelta) {
        this.scelta = scelta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}
