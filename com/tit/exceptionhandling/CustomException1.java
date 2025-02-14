package com.tit.exceptionhandling;

import java.util.Scanner;

public class CustomException1 {

    // Method to validate age for voting eligibility
    public static void validAge(double age) throws Exception {
        // Check if age is below the required limit
        if (age < 18) {
            throw new Exception("Invalid Age Exception."); // Throw an exception if age is less than 18
        }
        // Print confirmation if age is valid
        System.out.println("You are valid for voting.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object to take user input

        System.out.print("Enter your age: "); // Prompt the user for input
        double age = sc.nextDouble(); // Read user input

        try {
            validAge(age); // Call the method to check age validity
        } catch (Exception e) {
            // Handle the exception and display the error message
            System.out.println(e.getMessage());
        } finally {
            sc.close(); // Close the scanner to prevent resource leak
        }
    }
}
