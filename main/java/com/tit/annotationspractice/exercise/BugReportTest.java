package com.tit.annotationspractice.exercise;

import java.util.ArrayList;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo1 {
    String priority();
    String assignedTo();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class LegacyAPI5 {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. Please use newFeature() instead.");
    }

    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

class TaskManager5 {
    @TaskInfo(priority = "High", assignedTo = "John Doe")
    @BugReport(description = "Null pointer exception occurs on edge cases.")
    @BugReport(description = "Performance degradation observed with large inputs.")
    public void criticalTask() {
        System.out.println("Executing critical task.");
    }
}

public class BugReportTest {
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
            if (method.isAnnotationPresent(TaskInfo1.class)) {
                TaskInfo1 taskInfo = method.getAnnotation(TaskInfo1.class);
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }

            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);
                for (BugReport bug : bugReports.value()) {
                    System.out.println("Bug Report: " + bug.description());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

