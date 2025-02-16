package com.tit.replaceandmodifystring;

public class MultipleSpaceWithSingleSpace {
    public static void main(String[] args) {
        // Sample content with multiple spaces
        String content = "This    is     an   example    with   multiple spaces.";
        System.out.println("Before removing extra white space: " + content);
        content = removeExtraWhiteSpace(content);
        System.out.println("After removing extra white space: " + content);
    }

    // Method to remove extra white space from the given content
    private static String removeExtraWhiteSpace(String content) {
        // Regex pattern to match one or more white space characters
        String regex = "\\s+";
        // Replacing all occurrences of the regex pattern with a single space
        return content.replaceAll(regex, " ");
    }
}
