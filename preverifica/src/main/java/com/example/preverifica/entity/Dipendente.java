package com.example.preverifica.entity;

import java.util.Objects;

public class Dipendente {
    private int matricola;
    private String cognome;
    private String nome;
    private String qualifica;
    private int codiceDipartimento;

    public Dipendente() {

    }

    public Dipendente(String cognome, String nome, String qualifica, int codiceDipartimento) {
        this.cognome = cognome;
        this.nome = nome;
        this.qualifica = qualifica;
        this.codiceDipartimento = codiceDipartimento;
    }

    public Dipendente(int matricola, String cognome, String nome, String qualifica, int codiceDipartimento) {
        this.matricola = matricola;
        this.cognome = cognome;
        this.nome = nome;
        this.qualifica = qualifica;
        this.codiceDipartimento = codiceDipartimento;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQualifica() {
        return qualifica;
    }

    public void setQualifica(String qualifica) {
        this.qualifica = qualifica;
    }

    public int getCodiceDipartimento() {
        return codiceDipartimento;
    }

    public void setCodiceDipartimento(int codiceDipartimento) {
        this.codiceDipartimento = codiceDipartimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dipendente that = (Dipendente) o;
        return matricola == that.matricola && codiceDipartimento == that.codiceDipartimento && Objects.equals(cognome, that.cognome) && Objects.equals(nome, that.nome) && Objects.equals(qualifica, that.qualifica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricola, cognome, nome, qualifica, codiceDipartimento);
    }

    @Override
    public String toString() {
        return "Dipendente: " +
                "matricola=" + matricola +
                ", cognome='" + cognome + '\'' +
                ", nome='" + nome + '\'' +
                ", qualifica='" + qualifica + '\'' +
                ", codiceDipartimento=" + codiceDipartimento;
    }
}
