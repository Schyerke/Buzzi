package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    private Socket clientSocket;

    private DataOutputStream out;
    private DataInputStream in;


    public static void main(String[] args) {
        new Client().start();
    }


    public void start(){
        try{
            clientSocket = new Socket(HOST, PORT);
            System.out.println("Client started");
            while(true){
                out = new DataOutputStream(clientSocket.getOutputStream());
                in = new DataInputStream(clientSocket.getInputStream());

                // get pin
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter pin: ");
                String pin = scanner.nextLine();
                System.out.println("Pin: " + pin);
                out.writeUTF(pin);
                out.flush();

                // get response
                String response = in.readUTF();
                System.out.println("Server response: " + response);
                if(response.equals("OK")) {
                    System.out.println("Access granted");
                    break;
                }else if(response.equals("ERROR")) {
                    System.out.println("Access error, pin is incorrect");
                    System.out.println("Try again");
                }else{
                    System.out.println("Access denied");
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
