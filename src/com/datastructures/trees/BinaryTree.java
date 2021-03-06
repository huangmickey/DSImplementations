package com.datastructures.trees;

import java.util.ArrayList;

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
            if (value < curr.value) {
                if (curr.leftChild == null) {
                    curr.leftChild = node;
                    break;
                }
                curr = curr.leftChild;
            }
            if (value > curr.value) {
                if (curr.rightChild == null) {
                    curr.rightChild = node;
                    break;
                }
                curr = curr.rightChild;
            }
        }
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            for (int value : getNodesAtDistance(i))
                System.out.println(value);
        }
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        //  <root><left><right>

        // base condition
        if (root == null) {
            System.out.println("Base Case Hit");
            return;
        }

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {

        if (root == null) {
            System.out.println("null");
            return;
        }
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);

    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
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

    public boolean contains(int target) {
        return contains(root, target);
    }

    private boolean contains(Node root, int target) {
        if (root == null) return false;
        if (root.value == target) return true;
        return contains(target < root.value ? root.leftChild : root.rightChild, target);
    }

    public int height() {
        return height(root);
    }

    /**
     * Using post order traversal. Get the height of each node starting from the leaf nodes and pass them up to their
     * parents using recursion. Compare each height of each level after getting height returning the greater one back to
     * the parent until we reach root where root will ultimately compare whether its left or right subtree has a greater height
     * and chooses that one + 1;
     */
    private int height(Node root) {

        /*if (root == null) return -1;
        if (root.leftChild == null && root.rightChild == null) return 0;
        int heightOfLeftTree = height(root.leftChild);
        int heightOfRightTree = height(root.rightChild);
        return 1 + Math.max(heightOfLeftTree, heightOfRightTree);*/
        if (root == null) {
//            System.out.println("-1");
            return -1;
        }
        // base condition - reached a leaf node
        if (isLeaf(root)) {
//            System.out.println("Leaf Node = " + root.value + " : return 0");
            return 0;
        }
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min() {
        return min(root);
    }

    /**
     *  This is a method that finds min for Binary Trees and Binary Search Tree.
     *  This is not optimal for Binary Search Tree because values on the left are
     *  always smaller than the values on right, so you only need to traverse to the
     *  left all the way until a leaf node is found.
     *
     *  Time complexity: O(n)
     */
    private int min(Node root) {
        if (isLeaf(root)) return root.value;
        int leftValue = min(root.leftChild);
        int rightValue = min(root.rightChild);
        return Math.min(Math.min(leftValue, rightValue), root.value);
    }

    public int minBST() {
        return minBST(root);
    }

    /**
     *  Time complexity: O(log n)
     */
    private int minBST(Node root) {
        if (root == null) throw new IllegalStateException();

        Node curr = root;
        while (curr.leftChild != null) {
            curr = curr.leftChild;
        }
        return curr.value;
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public boolean equals(BinaryTree otherTree) {
        if (otherTree == null) return false;
        return equals(this.root, otherTree.root);
    }

    private boolean equals(Node thisNode, Node otherNode) {
        if (thisNode == null && otherNode == null) {
            System.out.println("null, null");
            return true;
        }

        if (thisNode != null && otherNode != null) {
            System.out.println((thisNode.value == otherNode.value) + "");
            return thisNode.value == otherNode.value && equals(thisNode.leftChild, otherNode.leftChild)
                    && equals(thisNode.rightChild, otherNode.rightChild);
        }
        return false;
    }

    private boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) return true;

        if (root.value < min || root.value > max) return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1) && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null) return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) {
//            System.out.println("null");
            return 0;
        }
        return 1 + size(root.leftChild) + size(root.rightChild);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if (root == null) return 0;
//        if (isLeaf(root)) {
//            return 1;
//        }
        if (root.leftChild == null && root.rightChild == null) return 1;
        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int max() {
        if (root == null) throw new IllegalStateException();
        return max(root);
    }

    private int max(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.leftChild == null && root.rightChild == null) return root.value;
        int left = max(root.leftChild);
        int right = max(root.rightChild);
        return Math.max(Math.max(left, right), root.value);
    }

    public int maxBST() {
        if (root == null) throw new IllegalStateException();
        return maxBST(root);
    }

    private int maxBST(Node root) {
        if (root.rightChild == null) return root.value;
        return maxBST(root.rightChild);
    }

    public boolean areSibling(int first, int second) {
        return areSibling(root, first, second);
    }

    private boolean areSibling(Node root, int first, int second) {
        if (root == null) return false;

        boolean isSibling = false;
        if (root.leftChild != null && root.rightChild != null) {
            if ( (root.leftChild.value == first && root.rightChild.value == second) ||
                    (root.rightChild.value == first && root.leftChild.value == second) ) {
                isSibling = true;
            }
        }
        System.out.println("reach return statement");
        return isSibling || areSibling(root.leftChild, first, second) || areSibling(root.rightChild, first, second);
    }

    public ArrayList<Integer> getAncestors(int target) {
        ArrayList<Integer> list = new ArrayList<>();
        getAncestors(root, target, list);
        return list;
    }

    private boolean getAncestors(Node root, int target, ArrayList<Integer> list) {
        if (root == null) return false;

        if (root.value == target) return true;

        if (getAncestors(root.leftChild, target, list) || getAncestors(root.rightChild, target, list)) {
            list.add(root.value);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        BinaryTree otherTree = new BinaryTree();

        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        tree.areSibling(8,10);

    }
}
