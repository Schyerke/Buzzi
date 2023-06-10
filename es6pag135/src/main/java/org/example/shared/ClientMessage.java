package org.example.shared;

public class ClientMessage {
    private String valoreCorrente;
    private String codice;
    private int matricola;

    public ClientMessage(String valoreCorrente, String codice, int matricola) {
        this.valoreCorrente = valoreCorrente;
        this.codice = codice;
        this.matricola = matricola;
    }

    public String getValoreCorrente() {
        return valoreCorrente;
    }

    public void setValoreCorrente(String valoreCorrente) {
        this.valoreCorrente = valoreCorrente;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }
}
