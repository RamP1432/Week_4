package com.tit.reflection.advancedlevel;
import java.lang.reflect.Field;

class ObjectToJson {
    public static String toJson(Object obj) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            try {
                String name = field.getName();
                Object value = field.get(obj);
                jsonBuilder.append("\"").append(name).append("\": ");

                if (value instanceof String) {
                    jsonBuilder.append("\"").append(value).append("\"");
                } else {
                    jsonBuilder.append(value);
                }

                if (i < fields.length - 1) {
                    jsonBuilder.append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Person2 person = new Person2("John Wick", 30);
        String json = ObjectToJson.toJson(person);
        System.out.println(json);
    }
}

class Person2 {
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

