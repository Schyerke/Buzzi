package org.example.shared;

public class ServerMessage {
    private String codice;
    private int matricola;

    public ServerMessage(String codice, int matricola) {
        this.codice = codice;
        this.matricola = matricola;
    }

    public String getCodice() {
        return codice;
    }

    public int getMatricola() {
        return matricola;
    }
}
