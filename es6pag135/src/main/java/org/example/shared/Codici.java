package org.example.shared;

public enum Codici {
    CODICE_AREA("codiceArea001");

    private final String codice;
    Codici(String codice){
        this.codice = codice;
    }

    public String getCodice() {
        return codice;
    }
}
