package com.tit.advanceproblem;

import java.util.*;
import java.util.regex.*;

public class ExtractCurrencyValue {
    public static void main(String[] args) {
        String content = "The price is $45.99, and the discount is 10.50.";

        // Call the method to extract currency values and store the result
        List<String> listOfCurrency = extractCurrencyValue(content);
        System.out.println(listOfCurrency);
    }

    // Method to extract currency values from the given content
    private static List<String> extractCurrencyValue(String content) {
        List<String> list = new ArrayList<>();

        // Create a regex pattern to match currency values
        String regex = "\\$?\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}
