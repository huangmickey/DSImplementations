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
