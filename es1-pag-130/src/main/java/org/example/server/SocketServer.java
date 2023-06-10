package org.example.server;

import com.google.gson.Gson;
import org.example.dto.RequestDto;
import org.example.dto.ResponseDto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer  {

    public static void main(String[] args) {
        Gson gson = new Gson();
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started");
            Socket socket = serverSocket.accept();

            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            RequestDto requestDto = gson.fromJson(in.readUTF(), RequestDto.class);

            System.out.println("Request from client: " + requestDto.getNum1() + " " + requestDto.getOperator() + " " + requestDto.getNum2());

            ResponseDto responseDto = createResponseDto(requestDto);

            System.out.println("Response to client: " + responseDto.getResult());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(gson.toJson(responseDto));

            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ResponseDto createResponseDto(RequestDto requestDto) {
        ResponseDto responseDto = new ResponseDto();
        int result = 0;
        switch(requestDto.getOperator()){
            case "+":
                result = requestDto.getNum1() + requestDto.getNum2();
                break;
            case "-":
                result = requestDto.getNum1() - requestDto.getNum2();
                break;
            case "*":
                result = requestDto.getNum1() * requestDto.getNum2();
                break;
            case "/":
                result = requestDto.getNum1() / requestDto.getNum2();
                break;
            default:
                System.out.println("Invalid operator");
                throw new IllegalStateException("Unexpected value: " + requestDto.getOperator());
        }
        responseDto.setResult(result);
        return responseDto;
    }

}
