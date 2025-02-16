package com.tit.annotationspractice.exercise;

class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. Please use newFeature() instead.");
    }

    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

public class LegacyAPITest {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature(); // This should show a warning
        api.newFeature();
    }
}
