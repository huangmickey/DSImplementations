import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    private Node head;

    // O(N) time complexity --> Adding new node at end of linked list requires traversing N node elements until the end before adding new node
    public void add(int data) {
        Node nextNode = new Node(data);

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
        int removedData = currNode.data;
        prev.next = null;
        return removedData;

    }
    // O(1)
    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.remove());
    }
}
