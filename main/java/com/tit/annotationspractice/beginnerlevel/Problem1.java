package com.tit.annotationspractice.beginnerlevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

// Step 2: Apply the annotation to methods
class TestClass {

    @ImportantMethod(level = "HIGH")
    public void importantMethod1() {
        System.out.println("Executing importantMethod1");
    }

    @ImportantMethod(level = "LOW")
    public void importantMethod2() {
        System.out.println("Executing importantMethod2");
    }

    public void regularMethod() {
        System.out.println("Executing regularMethod");
    }
}

// Step 3: Retrieve and print annotated methods using Reflection API
public class Problem1 {
    public static void main(String[] args) {
        Class<TestClass> obj = TestClass.class;

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + annotation.level());
            }
        }
    }
}

