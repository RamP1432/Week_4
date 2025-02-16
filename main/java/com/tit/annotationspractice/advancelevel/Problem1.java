package com.tit.annotationspractice.advancelevel;
import java.lang.reflect.Method;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AccessControl {

    @RoleAllowed("ADMIN")
    public void adminMethod() {
        System.out.println("Executing adminMethod");
    }

    @RoleAllowed("USER")
    public void userMethod() {
        System.out.println("Executing userMethod");
    }
}

public class Problem1 {

    private static String currentUserRole = "USER"; // Simulated user role

    public static void main(String[] args) throws Exception {
        AccessControl accessControl = new AccessControl();
        Class<?> obj = accessControl.getClass();

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);
                String requiredRole = annotation.value();

                if (currentUserRole.equals(requiredRole)) {
                    method.invoke(accessControl);
                } else {
                    System.out.println("Access Denied! Method: " + method.getName() + ", Required Role: " + requiredRole);
                }
            }
        }
    }
}

