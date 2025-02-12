package com.tit.queueinterface;

import java.util.*;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        // Custom comparator for max-heap (higher severity treated first)
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(
                (b,a) -> Integer.compare(a.severity, b.severity) // Sorting in descending order
        );

        // Adding patients to the queue
        triageQueue.offer(new Patient("Jyoti", 3));
        triageQueue.offer(new Patient("Akash", 5));
        triageQueue.offer(new Patient("Suman", 2));

        // Processing patients
        System.out.println("Treatment Order:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll()); // Polling the highest severity first
        }
    }
}
