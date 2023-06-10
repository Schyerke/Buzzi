package org.example.client;

import java.io.DataInputStream;
import java.net.Socket;

public class SocketClient {
    public static void main() {
        try (Socket socket = new Socket("localhost", 8080)) {
            System.out.println("Connected to server");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            int number = dataInputStream.readInt();
            System.out.println("Received number: " + number);


        } catch(Exception e){
            System.err.println(e.getMessage());
            System.err.println(java.util.Arrays.toString(e.getStackTrace()));
        }
    }

}
