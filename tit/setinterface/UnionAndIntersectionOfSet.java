package com.tit.setinterface;

import java.util.*;

public class UnionAndIntersectionOfSet {
    public static void main(String[] args) {
        // Creating two sets with predefined values
        Set<Integer> integerSet1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> integerSet2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));

        // Printing the union and intersection of the sets
        System.out.println("Union of sets: " + unionOfSets(integerSet1, integerSet2));
        System.out.println("Intersection of sets: " + intersectionOfSets(integerSet1, integerSet2));
    }

    // Method to find the intersection of two sets
    private static <T> Set<T> intersectionOfSets(Set<T> integerSet1, Set<T> integerSet2) {
        Set<T> temp = new HashSet<>();

        // Iterating through the first set and adding common elements to temp
        for (T t : integerSet1) {
            if (integerSet2.contains(t)) {
                temp.add(t);
            }
        }
        return temp;
    }

    // Method to find the union of two sets
    private static <T> Set<T> unionOfSets(Set<T> integerSet1, Set<T> integerSet2) {
        Set<T> temp = new HashSet<>();

        // Adding all elements from both sets to temp
        temp.addAll(integerSet1);
        temp.addAll(integerSet2);

        return temp;
    }
}
