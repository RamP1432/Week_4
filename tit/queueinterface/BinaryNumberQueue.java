package com.tit.queueinterface;

import java.util.*;

public class BinaryNumberQueue {
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer("1"); // Start with "1"

        for (int i = 0; i < N; i++) {
            String current = queue.poll(); // Get the front element
            result.add(current);

            // Generate the next two binary numbers
            queue.offer(current + "0");
            queue.offer(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 10;
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println(binaryNumbers); // Output: [1, 10, 11, 100, 101]
    }
}
