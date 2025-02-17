package com.tit.reflection.intermediatelevel;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Problem1 {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        Problem1 operations = new Problem1();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();

        System.out.println("Enter two integers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        try {
            // Get the method dynamically based on user input
            Method method = Problem1.class.getMethod(methodName, int.class, int.class);

            // Invoke the method with arguments
            int result = (int) method.invoke(operations, a, b);

            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
