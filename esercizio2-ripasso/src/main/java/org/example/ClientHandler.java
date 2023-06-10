package org.example;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Map;

public class ClientHandler implements Runnable {

    private Socket socket;

    private DataInputStream in;
    private DataOutputStream out;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            String msg = "Cosa vuoi fare?\n" +
                    "                    1: Restituire la quantita presente di un prodotto specifico\n" +
                    "                    2: Modificare la quantita di un prodotto specifico";

            msg += "\n\n";
            for (Map.Entry<String, Integer> entry : Prodotti.INSTANCE.getProdotti().entrySet()) {
                msg += "[" + entry.getKey() + "]: " + "[" + entry.getValue() + "]";
                msg += "\n";
            }

            out.writeUTF(msg);

            Gson gson = new Gson();

            String json = in.readUTF();
            System.out.println(json);
            ServerMessage serverMessage = gson.fromJson(json, ServerMessage.class);
            switch (serverMessage.getScelta()) {
                case 1 -> {
                    int q = Prodotti.INSTANCE.getQuantita(serverMessage.getId());
                    out.writeUTF("La quantita del prodotto: " + serverMessage.getId() + " e': "+ q);
                }
                case 2 -> {
                    Prodotti.INSTANCE.changeQuantita(serverMessage.getId(), serverMessage.getQuantita());
                    out.writeUTF("Prodotto: " + serverMessage.getId() + " cambiato la quantita in: " + serverMessage.getQuantita());
                }
                default -> out.writeUTF("Scelta sbagliata");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
