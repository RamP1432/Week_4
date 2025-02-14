package com.tit.exceptionhandling;

import java.util.Arrays;

public class ExceptionPropagation {
    // This method performs division and throws an ArithmeticException if division by zero occurs
    public static void method1(int a, int b) throws ArithmeticException {
        if (b == 0) {
            // Throw an exception if the denominator is zero
            throw new ArithmeticException("Exception in method1 division by zero.");
        }
        // Print the result of the division
        System.out.println("Result :" + a / b);
    }

    // This method calls method1 and propagates any ArithmeticException it throws
    public static void method2(int a, int b) throws ArithmeticException {
        method1(a, b);
    }

    public static void main(String[] args) {
        try {
            // Call method2 with arguments that will cause an ArithmeticException
            method2(3, 0);
        } catch (Exception e) {
            // Catch any exception and print its message
            System.out.println(e.getMessage());
            // Print the stack trace of the exception
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
