package com.datastructures.heap;

public class MaxHeap {

    public static void heapify(int[] array) {
        int lastParentIdx = array.length / 2 - 1;
        for (int i = lastParentIdx; i >= 0; i--) {
            heapify(array, i);
        }


//        for (int i = 0; i < array.length; i++) {
//            heapify(array,  i);
//        }
    }

    private static void heapify(int[] array, int idx) {
        int largerIdx = idx;

        int leftIdx = idx * 2 + 1;
        if (leftIdx < array.length &&
            array[leftIdx] > array[largerIdx]) {
            largerIdx = leftIdx;
        }

        int rightIdx = idx * 2 + 2;
        if (rightIdx < array.length &&
            array[rightIdx] > array[largerIdx]) {
            largerIdx = rightIdx;
        }

        if (idx == largerIdx) {
            return;
        }

        swap(array, idx, largerIdx);
        heapify(array, largerIdx);
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        Heap heap = new Heap();
        for (int num : array) {
            heap.insert(num);
        }

        for (int i = 0; i < k - 1; i++) {
            heap.remove();
        }

        return heap.max();

    }

}
