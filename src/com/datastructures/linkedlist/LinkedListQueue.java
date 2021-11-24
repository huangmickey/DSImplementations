package com.datastructures.linkedlist;

public class LinkedListQueue {

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node head;
    public Node tail;
    public int size;
    // [10 -> 20 -> 30]
    //  h           t
    public void enqueue(int data) {
        Node node = new Node(data);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();

        int data;
        if (head == tail) {
            data = head.data;
            head = tail = null;
        } else {
            data = head.data;
            Node temp = head.next;
            head.next = null;
            head = temp;
        }
        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();
        return head.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.peek());
    }

}
