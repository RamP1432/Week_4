package com.tit.exceptionhandling;

import java.util.Scanner;

public class FinallyBlockExecution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Number: ");
        int n1 = sc.nextInt();

        System.out.println("Enter Second Number: ");
        int n2 = sc.nextInt();

        try {
            // Attempt to divide the first number by the second number
            int result = n1 / n2;
            // Print the result of the division
            System.out.println(result);
        } finally {
            // This block executes regardless of whether an exception occurs
            System.out.println("Operation completed.");
        }
    }
}
