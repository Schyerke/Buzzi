package com.example;

public class BinaryTree {
    public Node root;

    public int maxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int rightDepth = maxDepth(node.right);
            int leftDepth = maxDepth(node.left);

            if (rightDepth > leftDepth) {
                return (rightDepth + 1);
            } else {
                return (leftDepth + 1);
            }
        }
    }

    public static boolean compare(Node nodeOne, Node nodeTwo) {
        if (nodeOne == null && nodeTwo == null) {
            return true;
        }
        return (nodeOne.data == nodeTwo.data && compare(nodeOne.left, nodeTwo.left)
                && compare(nodeOne.right, nodeTwo.right));
    }

    public static int findData(Node node, int data) {
        if (node == null)
            return -1;

        if (node.data == data)
            return data;

        if (node.data < data)
            return findData(node.right, data);
        else
            return findData(node.left, data);

    }

    public static void deleteNode(Node node, int data) {
        if (node == null) {
            return;
        }
        //TODO to finish
        if (node.left == null ){ 
            
        }
    }
}
