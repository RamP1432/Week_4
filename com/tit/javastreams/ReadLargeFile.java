package com.tit.javastreams;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadLargeFile {

    public static void readFileAndFilterErrors(String filePath) {
        try (
                // Using BufferedReader with InputStreamReader for efficient file reading
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Check if the line contains the word "error" (case-insensitive)
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line); // Print the matching line
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
            System.out.println(e.getMessage());        }
    }

    public static void main(String[] args) {
        // Path to the large file (modify as needed)
        String filePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week4_Day3\\largefile.txt";

        // Call the method to read and filter lines
        readFileAndFilterErrors(filePath);
    }
}
