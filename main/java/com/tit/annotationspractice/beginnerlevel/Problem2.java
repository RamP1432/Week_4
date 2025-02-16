package com.tit.annotationspractice.beginnerlevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

// Step 2: Apply the annotation to multiple methods
class Project {

    @Todo(task = "Implement login functionality", assignedTo = "Alice")
    public void login() {
        // Method implementation
    }

    @Todo(task = "Create database schema", assignedTo = "Bob", priority = "HIGH")
    public void createDatabase() {
        // Method implementation
    }

    @Todo(task = "Design user interface", assignedTo = "Charlie", priority = "LOW")
    public void designUI() {
        // Method implementation
    }
}

// Step 3: Retrieve and print all pending tasks using Reflection
public class Problem2 {
    public static void main(String[] args) {
        Class<Project> obj = Project.class;

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName() +
                        ", Task: " + annotation.task() +
                        ", Assigned to: " + annotation.assignedTo() +
                        ", Priority: " + annotation.priority());
            }
        }
    }
}

