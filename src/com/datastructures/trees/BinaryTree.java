package com.datastructures.trees;
public class BinaryTree {
    //  Tree
    //  Node (value, leftChild, rightChild)
    //  insert(value)
    //  find(value) : boolean
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }
    private Node root;

    public void insert(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        Node curr = root;
        while (true) {
            if (curr.value > value) {
                if (curr.leftChild == null) {
                    curr.leftChild = node;
                    break;
                }
                curr = curr.leftChild;
            }
            if (curr.value < value) {
                if (curr.rightChild == null) {
                    curr.rightChild = node;
                    break;
                }
                curr = curr.rightChild;
            }
        }
    }

    public boolean find(int value) {
        Node curr = root;
        while (curr != null) {
            if (value < curr.value)
                curr = curr.leftChild;
            else if (value > curr.value)
                curr = curr.rightChild;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        System.out.println(tree.find(11));
    }
}
