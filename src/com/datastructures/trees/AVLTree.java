package com.datastructures.trees;

public class AVLTree {

    private class AVLNode {
        private int value;
        private AVLNode left;
        private AVLNode right;

        public AVLNode(int value) {
            this.value = value;
        }

        public String toString() {
            return "Value=" + this.value;
        }
    }

    AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    public AVLNode insert(AVLNode root, int value) {
        if (root == null) {
            return new AVLNode(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        }
        else if (value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
    }
}
