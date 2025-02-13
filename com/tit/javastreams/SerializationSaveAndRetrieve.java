package com.tit.javastreams;

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private final int id;
    private final String name;
    private final String department;
    private final double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class SerializationSaveAndRetrieve {
    private static String filePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week4_Day3\\employee1.txt";

    public static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employees);
            System.out.println("Employees saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving employees. "+e.getMessage());
        }
    }

    public static void loadEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            List<Employee> employees = (List<Employee>) ois.readObject();
            System.out.println("Employees loaded successfully!");
            for(Employee emp : employees){
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees. "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Arjun", "HR", 50000));
        employees.add(new Employee(2, "Boby", "IT", 60000));
        employees.add(new Employee(3, "Chanchal", "Finance", 55000));

        saveEmployees(employees);
        loadEmployees();
    }
}

