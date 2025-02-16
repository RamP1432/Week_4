package com.tit.replaceandmodifystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CensorBadWords {
    public static void main(String[] args) {
        String content = "This is a bad example with some inappropriate words.";
        // Creating a list of bad words to be censored
        List<String> badWords = new ArrayList<>(Arrays.asList("bad", "inappropriate"));
        System.out.println("Content before removing bad words: " + content);
        content = removeBadWords(content, badWords);
        System.out.println("Content after removing bad words: " + content);
    }

    public static String removeBadWords(String content, List<String> badWords) {
        for (String badWord : badWords) {
            int n = badWord.length();  // Getting the length of the bad word
            // Replacing each bad word with "****"
            content = content.replaceAll("\\b" + badWord + "\\b", "****");
        }
        return content;  // Returning the censored content
    }
}
