package com.tit.advanceproblem;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPAddress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Creating a Scanner object for user input
        System.out.println("Enter your IP Address: ");
        String ipAddress = sc.nextLine();
        System.out.println("Is IP Address " + ipAddress + " valid: " + ipAddressValidator(ipAddress));
    }


    private static boolean ipAddressValidator(String ipAddress) {
        // The pattern matches four groups of four digits separated by dots
        String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
                + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
                + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
                + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(regex);  // Compiling the regular expression into a pattern
        Matcher matcher = pattern.matcher(ipAddress);  // Creating a matcher that will match the input against the pattern
        return matcher.matches();  // Returning whether the entire input sequence matches the pattern
    }
}
