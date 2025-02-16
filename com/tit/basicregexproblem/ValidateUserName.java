package com.tit.basicregexproblem;

import java.util.*;  // Importing the java.util package for Scanner
import java.util.regex.Matcher;  // Importing the Matcher class from java.util.regex package
import java.util.regex.Pattern;  // Importing the Pattern class from java.util.regex package

public class ValidateUserName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Creating a Scanner object for user input
        System.out.println("Enter Your Name: ");//taking user input
        String name = sc.nextLine();  // Reading a line of input from the user
        System.out.println("Is Name " + name + " valid: " + nameValidator(name));  // Printing whether the username is valid
    }

    private static boolean nameValidator(String name) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}";
        Pattern pattern = Pattern.compile(regex);  // Compiling the regular expression into a pattern
        Matcher matcher = pattern.matcher(name);  // Creating a matcher that will match the input against the pattern
        return matcher.matches();  // Returning whether the entire input sequence matches the pattern
    }
}
