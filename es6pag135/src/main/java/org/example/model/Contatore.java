package org.example.model;

public class Contatore {
    private int matricola;
    private int valoreLettura;

    public Contatore(int matricola, int valoreLettura) {
        this.matricola = matricola;
        this.valoreLettura = valoreLettura;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public int getValoreLettura() {
        return valoreLettura;
    }

    public void setValoreLettura(int valoreLettura) {
        this.valoreLettura = valoreLettura;
    }

    @Override
    public String toString() {
        return "Contatore{" +
                "matricola=" + matricola +
                ", valoreLettura=" + valoreLettura +
                '}';
    }
}
