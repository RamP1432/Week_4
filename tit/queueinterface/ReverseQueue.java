package com.tit.queueinterface;

import java.util.*;

public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Dequeue elements and push them onto the stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Step 2: Pop elements from the stack and enqueue them back
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}

