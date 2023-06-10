package com.example.tris_socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread{

    private DataOutputStream out;
    private DataInputStream in;
    private final ClientSocketWrapper clientSocketWrapper;
    public ClientHandler(ClientSocketWrapper clientSocketWrapper) {
        this.clientSocketWrapper = clientSocketWrapper;
    }

    @Override
    public void run() {
        try {
            Socket socket = clientSocketWrapper.socket();
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            out.writeUTF("Welcome to the server");
            out.writeUTF("You are player " + clientSocketWrapper.role());
            while (true) {
                String message = in.readUTF();
                System.out.println("Received: " + message);
                out.writeUTF("Received: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
