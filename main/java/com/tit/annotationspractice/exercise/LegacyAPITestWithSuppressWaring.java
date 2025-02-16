package com.tit.annotationspractice.exercise;

import java.util.ArrayList;

public class LegacyAPITestWithSuppressWaring {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList list = new ArrayList(); // Creating an ArrayList without generics
        list.add("Test");
        list.add(123); // Mixing types

        System.out.println(list);
    }
}

