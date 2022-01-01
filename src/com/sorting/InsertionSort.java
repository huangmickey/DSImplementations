package com.sorting;

public class InsertionSort {
    public void sortAscending(int[] array) {
        for (int i = 1; i < array.length; i++) {
          int curr = array[i];
          for (int j = i - 1; j >= 0; j--) {
              if (curr < array[j]) {
                  array[i] = array[j];
                  array[j] = curr;
                  i--;
              }
          }
        }
    }

    public void sortAscending2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
}
