package com.tit.annotationpractice;

import java.util.ArrayList;

class LegacyAPI2 {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. Please use newFeature() instead.");
    }

    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

public class LegacyAPITestWithSuppressWaring {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature(); // This should show a warning
        api.newFeature();
        ArrayList list = new ArrayList(); // Creating an ArrayList without generics
        list.add("Test");
        list.add(123); // Mixing types

        System.out.println(list);
    }
}

