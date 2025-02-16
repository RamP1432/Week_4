package com.tit.advanceproblem;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindRepeatingWord {
    public static void main(String[] args) {
        String content = "This is is a repeated repeated word test.";

        // Call the method to find repeating words and store the result
        Set<String> repeatingWord = findRepeatingWord(content);
        System.out.println(repeatingWord);
    }

    // Method to find repeating words in the given content using regex
    private static Set<String> findRepeatingWord(String content) {
        Set<String> result = new HashSet<>();

        // Define the regex pattern to match repeated words
        String regex = "\\b(\\w+)\\b\\s+\\b\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            result.add(matcher.group(1));
        }
        return result;
    }
}
