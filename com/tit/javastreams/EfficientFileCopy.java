package com.tit.javastreams;

import java.io.*;

public class EfficientFileCopy {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\patha\\OneDrive\\Desktop\\Week4_Day3\\source1.txt";
        String destinationFile = "C:\\Users\\patha\\OneDrive\\Desktop\\Week4_Day3\\destination1.txt";
        long startTime, endTime;

        // Using unbuffered streams
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            startTime = System.nanoTime();
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            endTime = System.nanoTime();
            System.out.println("Unbuffered Stream Time: " + (endTime - startTime) + " ns");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred while reading or writing: " + e.getMessage());
        }

        // Using buffered streams
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            startTime = System.nanoTime();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            endTime = System.nanoTime();
            System.out.println("Buffered Stream Time: " + (endTime - startTime) + " ns");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred while reading or writing: " + e.getMessage());
        }
    }
}

