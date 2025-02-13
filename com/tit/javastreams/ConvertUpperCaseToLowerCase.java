package com.tit.javastreams;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConvertUpperCaseToLowerCase {
    public static void convertFile(String inputFile, String outputFile) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File conversion completed successfully!");
        } catch (IOException e) {
            System.out.println("Error processing the file. "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inputFile ="C:\\Users\\patha\\OneDrive\\Desktop\\Week4_Day3\\source1.txt";
        String outputFile = "C:\\Users\\patha\\OneDrive\\Desktop\\Week4_Day3\\destination1.txt";
        convertFile(inputFile, outputFile);
    }
}

