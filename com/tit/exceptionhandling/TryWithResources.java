package com.tit.exceptionhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        // Define the path to the file that we want to read
        String filePath="C:\\Users\\patha\\OneDrive\\Desktop\\Week4_Day4\\File1Exception.txt";

        // Try-with-resources statement to automatically manage the resources
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read and print the first line of the file
            System.out.println(reader.readLine());
        } catch (IOException io) {
            // Handle IOException if an error occurs during file reading
            System.out.println("Error reading file.");
        }
    }
}
