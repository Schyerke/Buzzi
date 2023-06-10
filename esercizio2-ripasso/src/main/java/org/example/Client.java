package org.example;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        new ClientImpl().start();
    }


    public static class ClientImpl {
        private DataInputStream in;
        private DataOutputStream out;
        private final int PORT = 8080;

        public void start() {
            while(true) {
                try(Socket socket = new Socket("localhost", PORT)) {

                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());

                    String msg = in.readUTF();
                    System.out.println(msg);

                    Scanner scanner = new Scanner(System.in);
                    int scelta = Integer.parseInt(scanner.nextLine());

                    ServerMessage serverMessage = new ServerMessage();

                    switch (scelta) {
                        case 1 -> {
                            System.out.println("Inserisci l'id del prodotto");
                            String id = scanner.nextLine();
                            serverMessage.setId(id);

                            serverMessage.setScelta(scelta);
                        }
                        case 2 -> {
                            System.out.println("Inserisci l'id del prodotto");
                            String id = scanner.nextLine();
                            serverMessage.setId(id);

                            System.out.println();

                            System.out.println("Inserisci la nuova quantita");
                            int quantita = Integer.parseInt(scanner.nextLine());
                            serverMessage.setQuantita(quantita);

                            serverMessage.setScelta(scelta);
                        }
                        default -> {
                            System.out.println("Errore. Scelta sbagliata");
                        }
                    }

                    Gson gson = new Gson();

                    String json = gson.toJson(serverMessage);

                    out.writeUTF(json);

                    System.out.println(in.readUTF());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
