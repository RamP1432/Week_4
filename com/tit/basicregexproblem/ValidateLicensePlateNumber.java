package com.tit.basicregexproblem;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLicensePlateNumber {
    // Method to validate a license plate number
    public static boolean validateLicensePlatNumber(String input) {

        String regex = "^[A-Z]{2}[0-9]{4}";
        Pattern pattern = Pattern.compile(regex);  // Compiling the regular expression into a pattern
        Matcher matcher = pattern.matcher(input);  // Creating a matcher that will match the input against the pattern
        return matcher.matches();  // Returning whether the entire input sequence matches the pattern
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Creating a Scanner object for user input
        System.out.println("Enter License Number: ");
        String licenseNumber = sc.nextLine();  // Reading a line of input from the user
        // Printing whether the license plate number is valid
        System.out.println("Is License Number " + licenseNumber + " valid: " + validateLicensePlatNumber(licenseNumber));
    }
}
