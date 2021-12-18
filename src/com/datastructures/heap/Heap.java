package com.datastructures.heap;

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
        while (items[idx] > items[parent(idx)]) {
            // bubble up by swapping new value and parent value
            int temp = items[idx];
            items[idx] = items[parent(idx)];
            items[parent(idx)] = temp;
            idx = parent(idx);
        }
    }

    public int remove() {
        if (size == 0) throw new IllegalStateException("Heap is empty");

        // remove index 0 of heap by getting updating index 0 with last element in heap

        int removedValue = items[0];
        items[0] = items[size - 1];
        size--;
        // now check for violations of heap with this new swap with bubbleDown

        int idx = 0;

        while (items[idx] < items[leftChild(idx)] || items[idx] < items[rightChild(idx)]) {
            int temp = items[idx];
            int biggerChildIdx = rightChild(idx);
            if (items[leftChild(idx)] > items[biggerChildIdx]) {
                    biggerChildIdx = leftChild(idx);
            }
            items[idx] = items[biggerChildIdx];
            items[biggerChildIdx] = temp;

            idx = biggerChildIdx;
        }

        return removedValue;
    }

    private int leftChild(int idx) {
        return (idx * 2) + 1;
    }

    private int rightChild(int idx) {
        return leftChild(idx) + 1;
    }

    public boolean isFull() {
        return size == items.length;
    }

    private int parent(int idx) {
        return (idx - 1) / 2;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(12);
        heap.insert(5);
        heap.insert(4);
        heap.insert(1);
        heap.remove();

    }

}
