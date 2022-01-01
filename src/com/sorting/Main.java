package com.sorting;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {7, 3, 5, 1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sortAscending(numbers);
        System.out.println(Arrays.toString(numbers));

        SelectionSort selectionSort = new SelectionSort();
        int[] numbers2 = {7, 3, 5, 1};
        selectionSort.sortAscending(numbers2);
        System.out.println(Arrays.toString(numbers2));

        InsertionSort insertionSort = new InsertionSort();
        int[] numbers3 = {7, 3, 5, 1, 8, 2};
        insertionSort.sortAscending(numbers3);
        System.out.println(Arrays.toString(numbers3));
        int[] numbers4 = {7, 3, 5, 1, 8, 2};
        insertionSort.sortAscending2(numbers4);
        System.out.println(Arrays.toString(numbers4));
    }
}
