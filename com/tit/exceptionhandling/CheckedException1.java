package com.tit.exceptionhandling;

import java.io.*;

public class CheckedException1 {
    public static void main(String[] args) {
        // Define the file path
        String filePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week4_Day4\\File1Exception.txt";

        // Try-with-resources to automatically close the BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String str;
            // Read the file line by line
            while ((str = reader.readLine()) != null) {
                System.out.println(str); // Print each line to the console
            }
        } catch (IOException e) {
            // Handle file-related exceptions (e.g., file not found, permission issues)
            System.out.println("File is not present. " + e.getMessage());
        }
    }
}
