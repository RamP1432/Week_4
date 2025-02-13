package com.tit.javastreams;

import java.io.*;

public class ReadUserInputFromConsole {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath="C:\\Users\\patha\\OneDrive\\Desktop\\Week4_Day3\\user_info1.txt";
        try (FileWriter writer = new FileWriter(filePath)) {
            //Taking user input from console
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            String userInfo = "Name: " + name + "\nAge: " + age + "\nFavorite Language: " + language + "\n\n";
            //Storing user information
            writer.write(userInfo);
            System.out.println("Information saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while reading input or writing to file. "+e.getMessage());
        }
    }
}
