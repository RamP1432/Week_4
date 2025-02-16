package com.tit.reflection.basiclevel;

import java.lang.reflect.Method;
class Calculator {
    // Private method multiply
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        try {
            // Create an instance of Calculator
            Calculator calculator = new Calculator();

            // Access the private method 'multiply'
            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true);

            // Invoke the private method with arguments 5 and 3
            int result = (int) multiplyMethod.invoke(calculator, 5, 3);
            System.out.println("Result of multiplication: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

