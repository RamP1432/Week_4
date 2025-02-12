package com.tit.mapinterface;

import java.util.*;

public class KeyWithHighestValue {
    public static String findMaxKey(Map<String, Integer> inputMap) {
        if (inputMap.isEmpty()) return null; // Handle an empty map case

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        String maxKey = findMaxKey(map);
        System.out.println(maxKey); // Output: B
    }
}
