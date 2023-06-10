package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;

    public static void main(String[] args) {
        new Client().start();
    }
    public void start(){
        try{
            socket = new Socket(HOST, PORT);
            while(true){
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                //get message from user
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci una stringa, x per chiudere: ");
                String message = scanner.nextLine();
                if(message.equals("x")){
                    System.out.println("Chiusura in corso...");
                    break;
                }
                System.out.println("Sending message to server: " + message);

                out.writeUTF(message);
                out.flush();
                String response = in.readUTF();
                System.out.println("Server: " + response);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
