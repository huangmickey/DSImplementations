package com.sorting;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {-5, 20, 10, 3, 2, 0};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }

    public static String reverseString(String input) {
        if (input.equals("")) return "";
        return reverseString(input.substring(1)) + input.charAt(0);
    }
}
