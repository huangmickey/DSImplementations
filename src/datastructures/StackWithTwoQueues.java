package datastructures;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {

    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();
    private int nextTop;

    public void push(int data) {
        q1.add(data);
        nextTop = data;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException();
        if (q1.size() == 1) return q1.remove();

        while (q1.size() > 2) {
            q2.add(q1.remove());
        }
        nextTop = q1.remove();
        q2.add(nextTop);
        int currTop = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return currTop;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();
        return nextTop;
    }

    public int size() {
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.size() == 0;
    }

    public static void main(String[] args) {
        StackWithTwoQueues stack = new StackWithTwoQueues();
        stack.push(10);
        System.out.println(stack.peek());
        stack.push(20);
        System.out.println(stack.peek());
        stack.push(30);
        System.out.println(stack.peek());

    }

}
