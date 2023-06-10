package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Server().start();
    }

    public static class Server {
        private DataOutputStream out;
        private DataInputStream in;
        private ServerSocket serverSocket;
        private Socket socket;
        private static final int PORT = 8080;

        public void start() {
            try {
                serverSocket = new ServerSocket(PORT);
                socket = serverSocket.accept();
                while (true) {
                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF("Inviami un numero pari o dispari");
                    out.flush();

                    String clientMsg = in.readUTF();
                    try {
                        int integer = Integer.parseInt(clientMsg);
                        if (integer < 0) out.writeUTF("Ho ricevuto un numero intero negativo");
                        else if (integer % 2 == 0) out.writeUTF("Il numero risulta pari");
                        else out.writeUTF("Il numero risulta dispari");
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                    out.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class Client {
        public static void main(String[] args) {
            new ClientHandler().start();
        }


        public static class ClientHandler {

            private static final int PORT = 8080;
            private static final String HOST = "localhost";
            private DataInputStream in;
            private DataOutputStream out;
            private Socket socket;


            public void start() {
                Scanner scanner = new Scanner(System.in);
                try {
                    socket = new Socket(HOST, PORT);
                    while (true) {
                        in = new DataInputStream(socket.getInputStream());
                        out = new DataOutputStream(socket.getOutputStream());


                        String welcomeMsg = in.readUTF();
                        System.out.println(welcomeMsg);

                        System.out.println();

                        System.out.println("$ Inserisci un numero intero positivo, negativo, pari, o dispari");
                        int userNumber = Integer.parseInt(scanner.nextLine());

                        System.out.println("$ Hai inserito: " + userNumber);

                        out.writeUTF(String.valueOf(userNumber));

                        String resultMsg = in.readUTF();

                        System.out.println(resultMsg);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}