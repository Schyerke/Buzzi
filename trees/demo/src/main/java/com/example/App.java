package com.example;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // exerciseOne();
        //exerciseTwo();
        exerciseThree();
        // exerciseFour();
        // exerciseFive();
        // exerciseSix();
        // exerciseSeven();
        // exerciseEight();
        // exerciseNine();
        // exerciseTen();
    }

    private static void exerciseTen() {
    }

    private static void exerciseNine() {
    }

    private static void exerciseEight() {
    }

    private static void exerciseSeven() {
    }

    private static void exerciseSix() {
    }

    private static void exerciseFive() {
    }

    private static void exerciseFour() {
    }

    private static void exerciseThree() {
        //delete a node
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.right = new Node(3);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(4);

        BinaryTree.deleteNode(tree.root, 2);
    }

    private static void exerciseTwo() {
        BinaryTree treeOne = new BinaryTree();
        treeOne.root = new Node(1);
        treeOne.root.right = new Node(3);
        treeOne.root.left = new Node(2);
        treeOne.root.left.left = new Node(4);

        BinaryTree treeTwo = new BinaryTree();
        treeTwo.root = new Node(1);
        treeTwo.root.right = new Node(3);
        treeTwo.root.left = new Node(2);
        treeTwo.root.left.left = new Node(4);

        System.out.println("Data: " + BinaryTree.findData(treeOne.root, 4));

        boolean equal = BinaryTree.compare(treeOne.root, treeTwo.root);
        if (equal) {
            System.out.println("Gli alberi sono uguali");
        } else {
            System.out.println("gli alberi NON sono uguali");
        }
    }

    private static void exerciseOne() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node("Maria1");
        tree.root.left = new Node("Marco2");
        tree.root.right = new Node("Giulia3");
        tree.root.left.left = new Node("Mirko4");
        tree.root.left.right = new Node("Eleonora5");
        tree.root.right.left = new Node("Buzzi6");
        tree.root.right.right = new Node("Elena7");

        int result = tree.maxDepth(tree.root);
        System.out.println("Depth: " + result);
    }
}
