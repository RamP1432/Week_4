package com.tit.annotationspractice.advancelevel;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    // Getters for username and age
    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}


public class Problem2 {
    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();
        Map<String, String> jsonElements = new HashMap<>();

        for (Field field : objClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.name();
                String jsonValue = field.get(obj).toString();
                jsonElements.put(jsonKey, jsonValue);
            }
        }

        StringBuilder jsonString = new StringBuilder();
        jsonString.append("{");

        for (Map.Entry<String, String> entry : jsonElements.entrySet()) {
            jsonString.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
        }

        // Remove the last comma and space
        if (jsonString.length() > 1) {
            jsonString.setLength(jsonString.length() - 2);
        }

        jsonString.append("}");
        return jsonString.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Alice", 30);
        String jsonString = toJson(user);
        System.out.println(jsonString);
    }
}

