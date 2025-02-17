package com.tit.reflection.intermediatelevel;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
 @interface Author {
    String name();
}

@Author(name = "Author Name")
 class MyClass {
    // Class implementation
}

public class Problem2 {
    public static void main(String[] args) {
        try {
            // Get the class object
            Class<MyClass> obj = MyClass.class;

            // Check if the Author annotation is present
            if (obj.isAnnotationPresent(Author.class)) {
                // Retrieve the annotation
                Annotation annotation = obj.getAnnotation(Author.class);
                Author author = (Author) annotation;

                // Display the annotation value
                System.out.println("Author: " + author.name());
            } else {
                System.out.println("No Author annotation present.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
