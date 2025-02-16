package com.tit.extractionproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractAllCapitalizedWord {
    public static void main(String[] args) {
        // Sample input string containing words
        String input = "Hello word My Name is Java";
        // Extracting capitalized words from the input string
        List<String> capitalWords = extractCapitalWord(input);
        // Printing each extracted capitalized word
        for (String word : capitalWords) {
            System.out.print(word + "  ");
        }
    }

    // Method to extract words that start with a capital letter
    private static List<String> extractCapitalWord(String input) {
        // Regex pattern to match words starting with a capital letter
        // The pattern matches any sequence of characters that looks like a word starting with a capital letter
        String regex = "\\b[A-Z][a-zA-Z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> words = new ArrayList<>();

        while (matcher.find()) {
            words.add(matcher.group());
        }
        // Returning the list of capitalized words
        return words;
    }
}
