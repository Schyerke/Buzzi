package org.example.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class SocketServer {

    private static int number;

    public static void main() {
        try(ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeInt(number);
            System.out.println("Sent number: " + number);
            number++;

            dataOutputStream.flush();

            socket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
        }

    }
}
