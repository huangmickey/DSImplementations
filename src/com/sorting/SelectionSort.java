package com.sorting;

public class SelectionSort {

    public void sortAscending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // search for min item in the remaining unsorted arr
            int minIdx = i;
            for (int j = i; j < array.length; j++)
                if (array[j] < array[minIdx]) minIdx = j;
            swap(array, i, minIdx);
        }
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
