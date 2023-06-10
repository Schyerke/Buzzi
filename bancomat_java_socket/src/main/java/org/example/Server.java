package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    private DataOutputStream out;
    private DataInputStream in;
    private Socket clientSocket;

    private static final String PIN = "1234";

    private ServerSocket serverSocket;

    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {
        new Server().start();
    }

    public void start(){
        try{
            serverSocket = new ServerSocket(PORT);
            clientSocket = serverSocket.accept();
            System.out.println("Client connected");
            int attempts = 0;
            while(true){
                out = new DataOutputStream(clientSocket.getOutputStream());
                in = new DataInputStream(clientSocket.getInputStream());

                System.out.println("attempts: " + attempts);
                System.out.println("getting pin");
                String pin = in.readUTF();
                System.out.println("Client data: " + pin);

                if(pin.equals(PIN)){
                    out.writeUTF("OK");
                    break;
                }else{
                    if(attempts == MAX_ATTEMPTS-1){
                        System.out.println("Client blocked");
                        out.writeUTF("BLOCKED");
                        break;
                    }
                    out.writeUTF("ERROR");
                    attempts++;
                }
                out.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
