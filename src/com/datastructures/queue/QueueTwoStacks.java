package com.datastructures.queue;

import java.util.Stack;

public class QueueTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item) {
        stack1.push(item);
    }
    //  O(n)
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        moveStack1ToStack2();

        return stack2.pop();
    }

    private void moveStack1ToStack2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        moveStack1ToStack2();
        return stack2.peek();
    }

    public static void main(String[] args) {
        QueueTwoStacks queue = new QueueTwoStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        int first = queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(first);
    }
}
