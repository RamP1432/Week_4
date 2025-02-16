package com.tit.reflection.basiclevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the class name:");
        String className = scanner.nextLine();

        try {
            Class<?> cls = Class.forName(className);

            System.out.println("Class Name: " + cls.getName());

            // Display Constructors
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            System.out.println("Constructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println(" " + constructor);
            }

            // Display Fields
            Field[] fields = cls.getDeclaredFields();
            System.out.println("Fields:");
            for (Field field : fields) {
                System.out.println(" " + field);
            }

            // Display Methods
            Method[] methods = cls.getDeclaredMethods();
            System.out.println("Methods:");
            for (Method method : methods) {
                System.out.println(" " + method);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }

        scanner.close();
    }
}

