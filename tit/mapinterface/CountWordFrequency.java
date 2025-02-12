package com.tit.mapinterface;

import java.io.*;
import java.util.*;

public class CountWordFrequency {
    public static Map<String, Integer> countWordFrequency(String filePath) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Normalize text: Convert to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");

                // Split words and count frequency
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) { // Avoid empty words
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return wordCount;
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\patha\\OneDrive\\Desktop\\sample.txt";
        Map<String, Integer> wordFrequency = countWordFrequency(filePath);

        // Print word frequencies
        System.out.println(wordFrequency);
    }
}

