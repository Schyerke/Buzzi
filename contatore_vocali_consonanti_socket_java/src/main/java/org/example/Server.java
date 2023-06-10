package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {

    private DataOutputStream out;
    private DataInputStream in;
    private ServerSocket serverSocket;
    private Socket socket;

    private static final int PORT = 8080;

    private final List<String> vocali = List.of("a", "e", "i", "o", "u");

    public static void main(String[] args) {
        new Server().start();
    }
    public void start(){
        try{
            serverSocket = new ServerSocket(PORT);
            socket = serverSocket.accept();
            while(true){
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                String message = in.readUTF();
                System.out.println("Client: " + message);

                int vocaliCount = 0;
                int consonantiCount = 0;
                for (int i = 0; i < message.length(); i++) {
                    String lettera = String.valueOf(message.charAt(i));
                    if (vocali.contains(lettera)) {
                        vocaliCount++;
                    } else {
                        consonantiCount++;
                    }
                }

                out.writeUTF("Vocali: " + vocaliCount + " Consonanti: " + consonantiCount);
                out.flush();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
