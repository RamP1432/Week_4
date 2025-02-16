package com.tit.extractionproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmailAddress {
    public static void main(String[] args) {
        // Sample content containing email addresses
        String content = "Contact us at support@example.com and info@company.org";
        // Extracting email addresses from the content
        List<String> emails = emailExtractor(content);
        // Printing each extracted email address
        for (String s : emails) {
            System.out.println(s);
        }
    }

    // Method to extract email addresses from the given content
    private static List<String> emailExtractor(String content) {
        // Regex pattern to match email addresses
        // The pattern matches any sequence of characters that looks like an email address
        String regex = "[a-zA-Z0-9_+-.]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        ArrayList<String> emails = new ArrayList<>();
        // Finding all matches in the content
        while (matcher.find()) {
            // Adding each matched email address to the list
            emails.add(matcher.group());
        }
        // Returning the list of extracted email addresses
        return emails;
    }
}
