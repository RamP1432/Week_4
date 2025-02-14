package com.tit.exceptionhandling;

import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define an array of integers
        int[] array = {10, 20, 30, 40, 50};

        // Prompt the user to enter the index and the divisor
        System.out.println("Enter the array index: ");
        int index = sc.nextInt();
        System.out.println("Enter the divisor: ");
        int divisor = sc.nextInt();

        // Outer try-catch block to handle ArrayIndexOutOfBoundsException
        try {
            int element = array[index]; // Try to access the array element at the given index

            // Inner try-catch block to handle ArithmeticException
            try {
                int result = element / divisor; // Try to divide the element by the divisor
                System.out.println("Result: " + result); // Print the result
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!"); // Handle division by zero
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!"); // Handle invalid array index
        }
    }
}
