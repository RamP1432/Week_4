package com.tit.annotationspractice.intermediatelevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class PerformanceTest {

    @LogExecutionTime
    public void methodOne() {
        // Simulate some work with sleep
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void methodTwo() {
        // Simulate some work with sleep
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void methodThree() {
        // Simulate some work with sleep
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class Problem1 {
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();
        Class<?> obj = test.getClass();

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(test);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
                System.out.println("Method: " + method.getName() + " executed in " + duration + " ms");
            }
        }
    }
}
