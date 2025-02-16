package com.tit.advanceproblem;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractProgrammingLanguageName {
    public static void main(String[] args) {
        String content = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "Go");
        List<String> result = extractProgrammingLanguage(content, languages);
        // Print the extracted programming languages
        System.out.println(result);  // Expected Output: [Java, Python, JavaScript, Go]
    }

    // Method to extract programming languages from the given content
    private static List<String> extractProgrammingLanguage(String content, List<String> languages) {
        List<String> list = new ArrayList<>();
        // Loop through each programming language in the list
        for (String lang : languages) {
            // Create a regex pattern to match the language as a whole word
            String regex = "\\b" + lang + "\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);

            // If the language is found in the content, add it to the list
            if (matcher.find()) {
                list.add(lang);
            }
        }
        return list;
    }
}
