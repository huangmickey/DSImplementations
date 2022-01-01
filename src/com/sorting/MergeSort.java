package com.sorting;

public class MergeSort {

    public void sort(int[] array) {
        if (array.length < 2) return;

        int middle = array.length / 2;

        // [5,2,1,4,7] middle = 5/2 = 2
        //      m
        int[] left = new int[middle];
        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }

        int[] right = new int[array.length - middle];
        for (int i = middle; i < array.length; i++) {
            right[i - middle] = array[i];
        }

        sort(left);
        sort(right);

        merge(left, right, array);
    }

    private void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    public void mergeSort(int[] data, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data, start, mid, end);
        }
    }

    public static void merge(int[] data, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;

        // While both sub-array have values, try and merge them in sorted order
        while (i <= mid && j <= end) {
            if (data[i] < data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }

        // Add the rest of the values from left-sub array into the result
        while (i <= mid) temp[k++] = data[i++];
        // Add the rest of the values from right-sub array into the result
        while (j <= end) temp[k++] = data[j++];

        for (i = start; i <= end; i++) {
            data[i] = temp[i - start];
        }

    }
}
