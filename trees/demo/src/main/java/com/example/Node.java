package com.example;

public class Node {
    public String name;
    public int data;
    public Node left, right;
    public String helloworld;

    public Node(int data) {
        this.data = data;
    }

    public Node(String name) {
        this.name = name;
    }
}