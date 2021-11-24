package datastructures;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class TwoTailLinkedList {

    private class Node {
        private int value;
        private Node next;


        public Node(int value) {
            this.value = value;
        }
    }


    private Node first;
    private Node last;
    private int size;
    //  addFirst
    //  addLast
    //  deleteFirst
    //  deleteLast
    // contains
    // indexOf
    public void addFirst(int value) {
        Node node = new Node(value);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }
    public void addLast(int value) {
        Node node = new Node(value);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }


    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            return;
        }

        Node second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            return;
        }

        Node prev = getPrevious(last);
        last = prev;
        last = last.next;
        size--;
    }

    private Node getPrevious(Node node) {
        Node curr = first;
        while (curr != null) {
            if (curr.next == node) return curr;
            curr = curr.next;
        }
        return null;
    }

    public int indexOf(int value) {
        int index = 0;
        Node curr = first;
        while (curr != null) {
            if (curr.value == value) return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {

        int[] array = new int[size];
        Node curr = first;
        int index = 0;
        while (curr != null) {
            array[index++] = curr.value;
            curr = curr.next;
        }
        return array;
    }

    public void reverse() {
        if (isEmpty()) return;
        // [10 -> 20 -> 30]
        /*Node prev = null;
        last = first;
        while (first != null) {
            Node next = first.next;
            first.next = prev;
            prev = first;
            first = next;
        }
        first = prev;*/

        Node prev = first;
        Node curr = first.next;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        last = first;
        last.next = null;
        first = prev;

    }

    public int getKthFromEnd(int k) {
        if (isEmpty()) throw new IllegalStateException();
        Node a = first;
        Node b = first;
//        if (k > size) throw new IllegalArgumentException();
        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }
        while (b.next != null) {
            a = a.next;
            b = b.next;
        }
        return a.value;

    }

    public void printMiddle() {
        Node a = first;
        Node b = first;
        while (b.next != null && b.next.next != null) {
            b = b.next.next;
            a = a.next;
        }

        if (b.next == null) {
            System.out.println(a.value);
        } else {
            System.out.println(a.value + ", " + a.next.value);
        }
    }

    public boolean hasLoop() {
        if (isEmpty()) return false;
        Node a = first;
        Node b = first;
        while (b != null && b.next != null) {
            b = b.next.next;
            a = a.next;

            if (a == b) return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        TwoTailLinkedList list = new TwoTailLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
