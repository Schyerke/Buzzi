package com.example.chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatApplication extends Application {
    private ChatModel chatModel = ChatModel.getInstance();
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException, {
        FXMLLoader fxmlLoader = new FXMLLoader(ChatApplication.class.getResource("client.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("ENTER")) {

            }
        });
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}