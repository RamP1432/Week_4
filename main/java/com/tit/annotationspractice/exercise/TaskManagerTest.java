package com.tit.annotationspractice.exercise;

import java.util.ArrayList;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class LegacyAPI3 {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. Please use newFeature() instead.");
    }

    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "John Wick")
    public void criticalTask() {
        System.out.println("Executing critical task.");
    }
}

public class TaskManagerTest {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature(); // This should show a warning
        api.newFeature();

        @SuppressWarnings("unchecked")
        ArrayList list = new ArrayList(); // Creating an ArrayList without generics
        list.add("Test");
        list.add(123); // Mixing types

        System.out.println(list);

        // Retrieve annotation details using Reflection API
        try {
            Method method = TaskManager.class.getMethod("criticalTask");
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

