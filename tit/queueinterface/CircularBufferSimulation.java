package com.tit.queueinterface;

import java.util.*;

public class CircularBufferSimulation {
    private int[] buffer;
    private int front, rear, size, capacity;

    public CircularBufferSimulation(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    // Insert an element (overwrite oldest if full)
    public void insert(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % capacity;

        if (size < capacity) {
            size++; // Increase size if not full
        } else {
            front = (front + 1) % capacity; // Overwrite oldest
        }
    }

    // Get buffer elements as a list
    public List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(buffer[(front + i) % capacity]);
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBufferSimulation cb = new CircularBufferSimulation(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        System.out.println(cb.getBuffer()); // Output: [1, 2, 3]

        cb.insert(4); // Overwrites oldest (1)
        System.out.println(cb.getBuffer()); // Output: [2, 3, 4]

        cb.insert(5); // Overwrites 2
        System.out.println(cb.getBuffer()); // Output: [3, 4, 5]
    }
}

