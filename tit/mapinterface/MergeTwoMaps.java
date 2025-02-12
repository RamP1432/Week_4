package com.tit.mapinterface;

import java.util.*;

public class MergeTwoMaps {
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1); // Copy map1 to avoid modifying the original

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
             if(mergedMap.containsKey(entry.getKey())){
                 mergedMap.put(entry.getKey(), entry.getValue()+mergedMap.get(entry.getKey()));
             }
             else{
                 mergedMap.put(entry.getKey(), entry.getValue());
             }
        }

        return mergedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> result = mergeMaps(map1, map2);
        System.out.println(result); // Output: {A=1, B=5, C=4}
    }
}
