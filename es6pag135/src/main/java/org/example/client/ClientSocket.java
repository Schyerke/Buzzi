package org.example.client;

import com.google.gson.Gson;
import org.example.shared.ClientMessage;
import org.example.shared.ServerMessage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try{
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connessione al server stabilita");

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            ServerMessage serverMessage = gson.fromJson(dataInputStream.readUTF(), ServerMessage.class);
            System.out.println("Codice area: " + serverMessage.getCodice());
            System.out.println("Matricola: " + serverMessage.getMatricola());

            String codice = serverMessage.getCodice();
            int matricola = serverMessage.getMatricola();


            Scanner scanner = new Scanner(System.in);
            System.out.println("Inserisci il valore corrente del contatore: ");
            String valore = scanner.nextLine();

            dataOutputStream.writeUTF(gson.toJson(new ClientMessage(String.valueOf(valore), codice, matricola)));
            System.out.println("Valore inviato");
            socket.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
