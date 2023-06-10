package com.example.tris_socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {
    private static final int PORT = 5000;
    private static final int MAX_CLIENTS = 2;
    private static final int MAX_GAMES = 1;

    private DataOutputStream out;
    private DataInputStream in;
    private Socket socket;
    private int gameCounter;
    private final HashMap < Integer, ClientSocketWrapper > clients = new HashMap < > ();
    private ServerSocket serverSocket;

    public void start() {
        int client = 1;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                ClientSocketWrapper clientSocketWrapper = new ClientSocketWrapper(gameCounter, socket, client % 2 == 0 ? 2 : 1);
                clients.put(gameCounter, clientSocketWrapper);
                client++;
                if (client % 2 == 0) {
                    gameCounter++;
                }
                new Thread(new ClientHandler(clientSocketWrapper)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, ClientSocketWrapper> getClients() {
        return clients;
    }

    public List<ClientSocketWrapper> getClientsByGame(int game){
        List<ClientSocketWrapper> clientsByGame = new ArrayList<>();
        for (ClientSocketWrapper client : clients.values()) {
            if(client.game() == game){
                clientsByGame.add(client);
            }
        }
        return clientsByGame;
    }
}
