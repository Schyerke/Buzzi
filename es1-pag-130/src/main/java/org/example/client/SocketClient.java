package org.example.client;

import com.google.gson.Gson;
import org.example.dto.RequestDto;
import org.example.dto.ResponseDto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {

    private static RequestDto newRequestDto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int num1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the Operator: ");
        String operator = scanner.nextLine();
        System.out.println("Enter second number: ");
        int num2 = scanner.nextInt();
        scanner.nextLine();

        RequestDto requestDto = new RequestDto();
        requestDto.setNum1(num1);
        requestDto.setNum2(num2);
        requestDto.setOperator(operator);
        return requestDto;
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        try{
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connected to server");
            RequestDto requestDto = newRequestDto();
            System.out.println("Sending request to server");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF(gson.toJson(requestDto));
            out.flush();
            System.out.println("Waiting for response from server");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            ResponseDto responseDto = gson.fromJson(in.readUTF(), ResponseDto.class);

            System.out.println("Response from server: " + responseDto.getResult());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
