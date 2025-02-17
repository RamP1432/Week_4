package com.tit.reflection.advancedlevel;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;

class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(instance, fieldValue);
            }

            return instance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "John Wick");
        properties.put("age", 30);

        Person person = ObjectMapper.toObject(Person.class, properties);

        if (person != null) {
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());
        }
    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

