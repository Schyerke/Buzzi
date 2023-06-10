package org.example;


import org.example.client.SocketClient;
import org.example.server.SocketServer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
    * Realizza un sistema in cui il client riceve dal server un numero progressivo
 */
public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService executorServiceServer = Executors.newSingleThreadScheduledExecutor();
        executorServiceServer.scheduleAtFixedRate(SocketServer::main, 0, 1000, TimeUnit.MILLISECONDS);

        ScheduledExecutorService executorServiceClient = Executors.newSingleThreadScheduledExecutor();
        executorServiceClient.scheduleAtFixedRate(SocketClient::main, 0, 1000, TimeUnit.MILLISECONDS);

    }
}