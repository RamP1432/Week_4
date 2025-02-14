package com.tit.exceptionhandling;

import java.util.Scanner;

public class ThrowVsThrows {
    // This method calculates interest and throws an IllegalArgumentException if the input is invalid
    public static double calculateInterest(double amount, double rate, int year) {
        if (amount < 0 || rate < 0) {
            // Throw an exception if amount or rate is negative
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive.");
        }
        // Calculate and return the interest
        return (amount * rate * year) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the amount
        System.out.println("Please! Enter amount: ");
        double amount = sc.nextDouble();

        // Prompt the user to enter the rate
        System.out.println("Please! Enter rate: ");
        double rate = sc.nextDouble();

        // Prompt the user to enter the year
        System.out.println("Please! Enter Year: ");
        int year = sc.nextInt();

        try {
            // Calculate the interest and print it
            double interest = calculateInterest(amount, rate, year);
            System.out.println("Interest: " + interest);
        } catch (IllegalArgumentException ie) {
            // Catch and print the exception message if input is invalid
            System.out.println(ie.getMessage());
        }
    }
}
