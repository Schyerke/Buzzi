package org.example;

import org.example.client.SocketClient;
import org.example.server.SocketServer;

public class Main {
    public static void main(String[] args) {
        Runnable serverSocket = () -> {
            SocketServer.main(args);
        };
        new Thread(serverSocket).start();

        Runnable clientSocket = () -> {
            SocketClient.main(args);
        };
        new Thread(clientSocket).start();

    }
}