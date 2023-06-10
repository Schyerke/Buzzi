package com.example.chat;

public class ChatModel {
    private static ChatModel instance;
    private ChatModel() {
    }
    public static ChatModel getInstance() {
        if (instance == null) {
            instance = new ChatModel();
        }
        return instance;
    }

    public void handleSendBtn() {

    }
}
