package com.tit.advancejunittest;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    // Converts date from yyyy-MM-dd to dd-MM-yyyy
    public String formatDate(String inputDate) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        return date.format(outputFormatter);
    }

    public static void main(String[] args) {
        DateFormatter dateFormatter=new DateFormatter();
        System.out.println(dateFormatter.formatDate("2025-02-15"));
    }
}