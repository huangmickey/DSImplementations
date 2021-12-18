package com.datastructures.heap;

import java.util.Arrays;

public class Heap {

    private int[] items = new int[10];
    private int size;

    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException("Heap is full");
        }

        items[size++] = value;

        //if new value is greater than its parent then bubble up
        int idx = size - 1;
        while (idx > 0 && items[idx] > items[parent(idx)]) {
            // bubble up by swapping new value and parent value
            int temp = items[idx];
            items[idx] = items[parent(idx)];
            items[parent(idx)] = temp;
            idx = parent(idx);
        }
    }

    public int remove() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        int root = items[0];
        // remove index 0 of heap by getting updating index 0 with last element in heap
        items[0] = items[--size];
        int idx = 0;
        // now check for violations of heap with this new swap with bubbleDown
        while (!isValidParent(idx)) {
            int biggerChildIdx = biggerChildIdx(idx);
            int temp = items[idx];
            items[idx] = items[biggerChildIdx];
            items[biggerChildIdx] = temp;
            // reset the idx to the proper position because while loop will
            // continuously compare it against its new children nodes for heap status
            idx = biggerChildIdx;
        }

        return root;
    }

    private boolean isValidParent(int idx) {
        if (!hasLeftChild(idx)) {
            return true;
        }

        boolean isValid = items[idx] >= leftChildIdx(idx);

        if (!hasRightChild(idx)) {
            isValid = isValid && items[idx] >= rightChildIdx(idx);
        }

        return isValid;
    }

    private int biggerChildIdx(int idx) {
        if (!hasLeftChild(idx))
            return idx;
        if (!hasRightChild(idx))
            return leftChildIdx(idx);

        return (items[leftChildIdx(idx)] > items[rightChildIdx(idx)])
                ? leftChildIdx(idx) : rightChildIdx(idx);
    }

    private boolean hasLeftChild(int idx) {
        return leftChildIdx(idx) <= size;
    }

    private boolean hasRightChild(int idx) {
        return rightChildIdx(idx) <= size;
    }

    private int leftChildIdx(int idx) {
        return (idx * 2) + 1;
    }

    private int rightChildIdx(int idx) {
        return (idx * 2) + 2;
    }

    private int parent(int idx) {
        return (idx - 1) / 2;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public String toString() {
        int[] displayHeap = new int[size];
        System.arraycopy(items, 0, displayHeap, 0, size);
        return Arrays.toString(displayHeap);
    }
}
