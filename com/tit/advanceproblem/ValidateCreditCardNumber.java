package com.tit.advanceproblem;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCreditCardNumber {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter a credit card number
        System.out.println("Enter your credit card number: ");
        String cardNumber = sc.nextLine();

        // Validate and display the result
        System.out.println("Is Credit Card Number " + cardNumber + " valid: " + creditCardNumberValidator(cardNumber));

        // Close the Scanner object
        sc.close();
    }

    private static boolean creditCardNumberValidator(String cardNumber) {
        String regex = "^(4\\d{15}|5\\d{15})$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the user input against the pattern
        Matcher matcher = pattern.matcher(cardNumber);

        // Return true if the card number matches the pattern, otherwise false
        return matcher.matches();
    }
}
