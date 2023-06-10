package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    public static void main(String[] args) {
        Prodotti.INSTANCE.start();
        new ServerImpl().start();
    }


    public static class ServerImpl{

        private final int PORT = 8080;

        public void start(){
            try(ServerSocket serverSocket = new ServerSocket(PORT)) {

                while(true) {
                    Socket socket = serverSocket.accept();
                    Thread thread = new Thread(new ClientHandler(socket));
                    thread.start();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
