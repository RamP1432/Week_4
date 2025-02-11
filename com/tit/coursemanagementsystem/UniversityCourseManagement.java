package com.tit.coursemanagementsystem;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing a course type
abstract class CourseType {
    private String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course Type: " + name;
    }
}

// Specific course types
class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based Course");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based Course");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based Course");
    }
}

// Generic Course class with bounded type parameter
class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + " (" + courseType.getName() + ")";
    }
}

// Course management system
class CourseManagement {
    private List<Course<? extends CourseType>> courses;

    public CourseManagement() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public void displayCourses() {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}

// Main class to test the implementation
public class UniversityCourseManagement {
    public static void main(String[] args) {
        CourseManagement management = new CourseManagement();

        // Creating courses
        Course<ExamCourse> mathCourse = new Course<>("Advanced Mathematics", new ExamCourse());
        Course<AssignmentCourse> csCourse = new Course<>("Data Structures", new AssignmentCourse());
        Course<ResearchCourse> physicsCourse = new Course<>("Quantum Mechanics", new ResearchCourse());

        // Adding courses to a management system
        management.addCourse(mathCourse);
        management.addCourse(csCourse);
        management.addCourse(physicsCourse);

        // Displaying all courses
        management.displayCourses();
    }
}

