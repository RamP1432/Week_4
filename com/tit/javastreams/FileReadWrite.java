package com.tit.javastreams;

import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        //Source and destination file address
        String sourceFile = "C:\\Users\\patha\\OneDrive\\Desktop\\Week4_Day3\\source1.txt";
        String destinationFile = "C:\\Users\\patha\\OneDrive\\Desktop\\Week4_Day3\\destination1.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            //Reading file from source
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred while reading or writing: " + e.getMessage());
        }
    }
}

