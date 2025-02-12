package com.tit.setinterface;

import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {
        // Creating two sets with predefined values
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));

        // Printing the symmetric difference of the sets
        System.out.println("Symmetric Difference of Sets: " + findSymmetricDifference(set1, set2));
    }

    // Method to find the symmetric difference of two sets
    private static <T> Set<T> findSymmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> temp = new HashSet<>();

        // Adding elements from set1 that are not in set2
        for (T t : set1) {
            if (!set2.contains(t)) {
                temp.add(t);
            }
        }

        // Adding elements from set2 that are not in set1
        for (T t : set2) {
            if (!set1.contains(t)) {
                temp.add(t);
            }
        }

        return temp;
    }
}
