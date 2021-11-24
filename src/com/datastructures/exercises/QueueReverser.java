package com.datastructures.exercises;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Given an integer K and a queue of integers, write code to reverse the order of the first K elements of the queue.
 */

public class QueueReverser {

    public void reverse(Queue<Integer> queue, int k) {
        if (k > queue.size() || k < 0) throw new IllegalArgumentException();

        Stack<Integer> stack = new Stack<>();
        /*int count = 0;
        while (!queue.isEmpty()) {
            while (count < k) {
                stack.push(queue.remove());
                count++;
            }
            while (!stack.isEmpty()) {
                int num = stack.pop();
                System.out.println(num);
                queue.add(num);
            }
            for (int i = 0; i < queue.size() - k; i++) {
                queue.add(queue.remove());
            }
            return;
        }*/

        for (int i = 0; i < k; i++) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.remove());
        }

    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        QueueReverser reverser = new QueueReverser();
        reverser.reverse(queue, 3);

        System.out.println(queue);
    }
}
