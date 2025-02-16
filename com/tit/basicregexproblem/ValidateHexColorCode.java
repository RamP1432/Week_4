package com.tit.basicregexproblem;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateHexColorCode {
    public static boolean isValidColorCode(String input){
        String regex="^#[a-fA-F0-9]{6}$";
        return Pattern.matches(regex,input);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter hex color code: ");
        String hexColorCode=sc.nextLine();
        System.out.println("Is Hex code "+hexColorCode+" valid : "+isValidColorCode(hexColorCode));
    }
}
