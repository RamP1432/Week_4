package com.tit.extractionproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDate {
    public static void main(String[] args) {
        String content="The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> dates=extractDates(content);
        for(String date : dates){
            System.out.println(date);
        }
    }

    private static List<String> extractDates(String content) {
        String regex="\\b\\d{2}/\\d{2}/\\d{4}\\b";
        List<String> dates=new ArrayList<>();
        Pattern pattern= Pattern.compile(regex);
        Matcher matcher=pattern.matcher(content);
        while(matcher.find()){
            dates.add(matcher.group());
        }
        return dates;
    }
}
