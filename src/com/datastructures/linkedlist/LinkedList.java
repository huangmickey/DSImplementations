package com.datastructures.linkedlist;

import java.util.NoSuchElementException;

/**
 * Linked lists grow and shrink automatically. In a linked list, nodes are linked together. A linked list node contain two fields,
 * value and a Node which it points to. Usually there is a head and a tail node which are the first node and last nodes of a linked list.
 *
 * Memory Address of each node can be all over the place, therefore we need each node to reference anotehr node.
 * Time complexity:
 * Lookup: By Value --> O(n) because the last value
 *         By Index --> Not possible, have to traverse list until value is found O(n)
 * Insert:
 *         At the End       --> O(1)    :   Tail points to new node at end
 *         At the Beginning --> O(1)    :   Head points to new node at beginning
 *         In the middle    --> O(n)
 * Delete:
 *         From the Beginning   --> O(1)
 *         From the End         --> O(n)    : Have to get previous node before the last in order to delete last node
 *         From the Middle      --> O(n)
 */
public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }

    }

    private Node head;

    // O(N) time complexity --> Adding new node at end of linked list requires traversing N node elements until the end before adding new node
    public void add(int value) {
        Node nextNode = new Node(value);

        if (isEmpty()) {
            head = nextNode;
        } else {
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = nextNode;
        }
    }
    // O(N) time complexity --> Removing node at end of linked list requires traversing N nodes until end of list before removing node
    public int remove() {
        if (isEmpty()) throw new NoSuchElementException();
        Node currNode = head;
        Node prev = currNode;
        while (currNode.next != null) {
            prev = currNode;
            currNode = currNode.next;
        }
        int removedData = currNode.value;
        prev.next = null;
        return removedData;

    }
    // O(1)
    public boolean isEmpty() {
        return head == null;
    }

    public int removeAt(int index) {
        if (isEmpty()) throw new NoSuchElementException();
        Node targetNode = head;
        Node prev = targetNode;
        int i = 0;
        while (i != index) {
            prev = targetNode;
            targetNode = head.next;
            if (targetNode == null) throw new NoSuchElementException();
            i++;
        }
        int removedData = targetNode.value;
        prev.next = targetNode.next;
        return removedData;
    }

    public void reverseRecursive() {
        this.head = reverse(this.head);
    }

    private Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

    //   10 -> 20 -> 30 -> null

    public void reverseIterative() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            res.append(curr.value).append(" ");
            curr = curr.next;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
//        list.add(5);
//        list.add(19);
//        list.add(21);
//        list.add(99);
//        System.out.println(list);
//        list.reverseRecursive();
//        System.out.println(list);

        LinkedList list2 = new LinkedList();
        list2.add(5);
        list2.reverseIterative();
        System.out.println(list2);

    }
}
