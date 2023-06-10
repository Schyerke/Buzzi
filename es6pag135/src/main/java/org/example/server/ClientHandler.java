package org.example.server;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Random;

import org.example.model.Contatore;
import org.example.persistenza.FileHelper;
import org.example.shared.ClientMessage;
import org.example.shared.Codici;
import org.example.shared.ServerMessage;

public class ClientHandler extends Thread{
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Gson gson = new Gson();
        try{
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            Random random = new Random();
            int matricola = random.nextInt(1000);
            out.writeUTF(gson.toJson(new ServerMessage(Codici.CODICE_AREA.getCodice(), matricola)));
            out.flush();

            ClientMessage clientMessage = gson.fromJson(in.readUTF(), ClientMessage.class);
            System.out.println("Valore: " + clientMessage.getValoreCorrente());

            Contatore contatore = new Contatore(matricola, Integer.parseInt(clientMessage.getValoreCorrente()));
            FileHelper.INSTANCE.salvaContatore(contatore);
            System.out.println("Contatore salvato");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
