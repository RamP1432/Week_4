package com.tit.listinterface;

import java.util.*;

public class RotateList {
    // Method to rotate a list by a given number of positions
    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size;
        if (positions < 0) {
            positions += size;
        }
        Collections.rotate(list,-positions);
    }

    public static void main(String[] args) {
        // Example with ArrayList
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original List: " + list);
        rotateList(list, 2);
        System.out.println("Rotated List: " + list);
    }
}

