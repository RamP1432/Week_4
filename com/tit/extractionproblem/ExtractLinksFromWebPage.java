package com.tit.extractionproblem;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinksFromWebPage {
    public static void main(String[] args) {
        // Sample content containing URLs
        String content = "Visit https://www.google.com and http://example.org for more info.";
        // Extracting URLs from the content
        List<String> links = extractLinks(content);
        // Printing each extracted URL
        for (String link : links) {
            System.out.println(link);
        }
    }

    // Method to extract URLs from the given content
    private static List<String> extractLinks(String content) {
        // The pattern matches any sequence of characters that looks like a URL
        String regex = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}\\S*\\b";
        Pattern pattern = Pattern.compile(regex);  // Compiling the regular expression into a pattern
        Matcher matcher = pattern.matcher(content);  // Creating a matcher that will match the input against the pattern
        List<String> links = new ArrayList<>();
        // Finding all matches in the content
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }
}
