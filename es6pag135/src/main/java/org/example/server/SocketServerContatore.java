package org.example.server;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerContatore {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8080)){
            while(true){
                System.out.println("Server in attesa di connessioni...");
                Socket socket = serverSocket.accept();
                System.out.println("Connessione accettata");
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
