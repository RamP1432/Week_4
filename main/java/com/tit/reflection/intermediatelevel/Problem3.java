package com.tit.reflection.intermediatelevel;

import java.lang.reflect.Field;
class Configuration {
    private static String API_KEY = "initial_key";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        try {
            // Get the class object
            Class<Configuration> configClass = Configuration.class;

            // Get the private static field API_KEY
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Make the field accessible
            apiKeyField.setAccessible(true);

            // Modify the value of the field
            apiKeyField.set(null, "new_api_key");

            // Print the new value of the field
            System.out.println("Modified API_KEY: " + Configuration.getApiKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
