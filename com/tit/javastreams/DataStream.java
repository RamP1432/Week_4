package com.tit.javastreams;

import java.io.*;

public class DataStream {
    //File location
    private static final String FILE_NAME = "C:\\Users\\patha\\OneDrive\\Desktop\\Week4_Day3\\studentData1.txt";
    //Storing student data
    public static void storeStudentData(int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data stored successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            System.out.println(e.getMessage());
        }
    }
    //Retrieving student data
    public static void retrieveStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("Stored Student Data:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
            System.out.println(e.getMessage());
        }
    }
    //Main method for testing
    public static void main(String[] args) {
        storeStudentData(101, "Anish", 3.8);
        storeStudentData(102, "Sarvesh", 3.6);
        retrieveStudentData();
    }
}
