package com.tit.reflection.basiclevel;

import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int rollNumber;

    // Constructor
    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', rollNumber=" + rollNumber + '}';
    }
}

public class Problem4 {
    public static void main(String[] args) {
        try {
            // Get the Student class
            Class<Student> studentClass = Student.class;

            // Get the constructor of the Student class
            Constructor<Student> constructor = studentClass.getConstructor(String.class, int.class);

            // Create an instance of Student class using the constructor
            Student student = constructor.newInstance("John Wick", 101);

            // Display the created instance
            System.out.println("Created Student instance: " + student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
