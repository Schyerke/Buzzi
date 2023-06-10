package org.example;

import java.util.HashMap;

public enum Prodotti {
    INSTANCE;

    // Key => id
    // Value => quantita
    private final HashMap<String, Integer> prodotti = new HashMap<>();

    public void start(){
        prodotti.put("azzini", 5);
        prodotti.put("sapone", 6);
        prodotti.put("occhio", 2);
        prodotti.put("rene", 6);
        prodotti.put("cuore", 4);
        prodotti.put("occhiali", 100);
    }

    public HashMap<String, Integer> getProdotti() {
        return prodotti;
    }

    public int getQuantita(String id) {
        return prodotti.getOrDefault(id, -1);
    }

    public void changeQuantita(String id, int quantita) {
        this.prodotti.put(id, quantita);
    }

}
