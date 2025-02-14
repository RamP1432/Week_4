package com.tit.exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

// Class containing the method to perform division
class Solver {
    // Method to divide two numbers, throws ArithmeticException if divisor is zero
    public static double divideNum(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Dividend cannot be zero."); // Throw exception if divisor is zero
        }
        return a / b; // Perform division
    }
}

public class UnCheckedException1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner to take user input
        try {
            System.out.println("Enter two numbers:");
            double a = sc.nextDouble();
            double b = sc.nextDouble();

            double res = Solver.divideNum(a, b); // Perform division
            System.out.println("Result: " + res);
        } catch (ArithmeticException ae) {
            // Handle division by zero exceptions
            System.out.println(ae.getMessage());
        } catch (InputMismatchException ime) {
            // Handle input mismatch exception when non-numeric values are entered
            System.out.println("Please enter a valid number: " + ime.getMessage());
        }
    }
}
