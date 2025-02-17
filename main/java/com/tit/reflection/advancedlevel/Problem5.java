package com.tit.reflection.advancedlevel;
import java.lang.reflect.Method;
 class SampleClass {
    public void method1() {
        // Simulate some work with sleep
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method2() {
        // Simulate some work with sleep
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

 class MethodTimer {
    public static void measureMethodExecutionTime(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            long startTime = System.nanoTime();

            method.invoke(obj);

            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("Execution time of " + methodName + ": " + duration + " nanoseconds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Problem5{
    public static void main(String[] args) {
        SampleClass sample = new SampleClass();

        MethodTimer.measureMethodExecutionTime(sample, "method1");
        MethodTimer.measureMethodExecutionTime(sample, "method2");
    }
}

