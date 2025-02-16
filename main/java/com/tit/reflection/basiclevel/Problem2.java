package com.tit.reflection.basiclevel;

import java.lang.reflect.Field;
class Person {
    private int age;

    // Constructor
    public Person(int age) {
        this.age = age;
    }

    // Getter for age (optional)
    public int getAge() {
        return age;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            Person person = new Person(25);

            // Access the private field 'age'
            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);

            // Retrieve the value of the private field
            int age = (int) ageField.get(person);
            System.out.println("Original age: " + age);

            // Modify the value of the private field
            ageField.set(person, 30);

            // Retrieve the modified value
            int modifiedAge = (int) ageField.get(person);
            System.out.println("Modified age: " + modifiedAge);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

