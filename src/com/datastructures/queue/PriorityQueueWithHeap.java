package com.datastructures.queue;

import com.datastructures.heap.Heap;

public class PriorityQueueWithHeap {
    private Heap heap = new Heap();
    private int size;

    public void enqueue(int item) {
        heap.insert(item);
    }

    public int dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public boolean isFull() {
        return heap.isFull();
    }
}
