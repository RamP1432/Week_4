package com.tit.mapinterface;

import java.util.*;

public class GroupObjectByProperty {
    public static void main(String[] args) {
        // Create a map of employees and their respective departments
        Map<String, String> map = new HashMap<>();
        map.put("Rohan", "HR");
        map.put("Ram", "Manager");
        map.put("Anuj", "HR");
        map.put("Sahil", "IT");
        map.put("Diya", "Manager");
        map.put("Anish", "IT");

        // Call the method to group employees by department
        Map<String, List<String>> group = groupByProperty(map);

        // Print the grouped employees by department
        System.out.println(group);
    }

    private static Map<String, List<String>> groupByProperty(Map<String, String> map) {
        // Create a new map to store grouped employees
        Map<String, List<String>> group = new HashMap<>();

        // Iterate through the input map
        for (Map.Entry<String, String> entry : map.entrySet()) {
            // Check if the department is already present in the map
            if (group.containsKey(entry.getValue())) {
                // Add the employee to the existing department list
                group.get(entry.getValue()).add(entry.getKey());
            } else {
                // Create a new list for the department and add the employee
                group.put(entry.getValue(), new ArrayList<>());
                group.get(entry.getValue()).add(entry.getKey());
            }
        }
        return group; // Return the grouped result
    }
}
