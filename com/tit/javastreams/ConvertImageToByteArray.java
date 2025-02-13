package com.tit.javastreams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ConvertImageToByteArray {

    public static byte[] convertImageToByteArray(String imagePath) {
        try {
            return Files.readAllBytes(Paths.get(imagePath));
        } catch (IOException e) {
            System.out.println("Error reading image file. "+e.getMessage());
            return null;
        }
    }

    public static void writeByteArrayToImage(byte[] imageData, String outputPath) {
        try (FileOutputStream fos = new FileOutputStream(outputPath)) {
            fos.write(imageData);
            System.out.println("Image successfully written to " + outputPath);
        } catch (IOException e) {
            System.out.println("Error writing image file. "+e.getMessage());

        }
    }

    public static void main(String[] args) {
        String inputImagePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week4_Day3\\outputImage.jpeg";
        String outputImagePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week4_Day3\\outputImage.jpeg";

        byte[] imageData = convertImageToByteArray(inputImagePath);
        if (imageData != null) {
            writeByteArrayToImage(imageData, outputImagePath);

            // Verify the files are identical
            try {
                boolean isIdentical = Arrays.equals(Files.readAllBytes(Paths.get(inputImagePath)), Files.readAllBytes(Paths.get(outputImagePath)));
                System.out.println("Are the files identical? " + isIdentical);
            } catch (IOException e) {
                System.out.println("Error verifying files.");
            }
        }
    }
}
