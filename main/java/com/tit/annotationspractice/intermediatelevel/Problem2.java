package com.tit.annotationspractice.intermediatelevel;
import java.lang.reflect.Field;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        // Validate the length of the username using the @MaxLength annotation
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                int maxLength = annotation.value();
                if (username.length() > maxLength) {
                    throw new IllegalArgumentException("Username exceeds the maximum length of " + maxLength + " characters.");
                }
            }
            this.username = username;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        // Test the User class
        try {
            User user1 = new User("shortName");
            System.out.println("User1 created with username: " + user1.getUsername());

            User user2 = new User("thisIsALongUsername");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

