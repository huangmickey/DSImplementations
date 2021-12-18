package com.datastructures.trees;

public class BinarySearchTree {

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {

        if (root == null) return;
        System.out.println(root.value);
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }
        traverseInOrder(root.left);
        System.out.println(root.value);
        traverseInOrder(root.right);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) return;
        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.println(root.value);
    }

    public boolean find(int target) {
        return find(root, target);
    }

    private boolean find(Node root, int target) {
        if (root == null) return false;
        if (root.value == target) return true;
        if (target < root.value) {
            return find(root.left, target);
        } else {
            return find(root.right, target);
        }
    }




    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(7);
        bst.insert(4);
        bst.insert(9);
        bst.insert(1);
        bst.insert(6);
        bst.insert(8);
        bst.insert(10);
        bst.find(10);
    }


}
