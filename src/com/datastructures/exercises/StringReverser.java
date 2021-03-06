package com.datastructures.exercises;

import java.util.Stack;

public class StringReverser {

    public String reverse(String input) {
        if (input == null) throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        StringReverser reverser = new StringReverser();
        String s = reverser.reverse("Hello World!");
        System.out.println(s);
    }

}
