package com.tit.advanceproblem;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSSNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter a Social Security Number (SSN)
        System.out.println("Please Enter Your SS Number: ");
        String ssNumber = sc.nextLine();
        System.out.println("Is SSNumber " + ssNumber + " valid : " + validatorOfSSNumber(ssNumber));
    }

    // Method to validate the SSN using a regular expression
    private static boolean validatorOfSSNumber(String ssNumber) {
        // Define the regex pattern to match valid SSN format (e.g., 123-45-6789)
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssNumber);
        return matcher.matches();
    }
}
