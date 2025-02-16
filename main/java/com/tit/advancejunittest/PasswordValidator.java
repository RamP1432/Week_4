package com.tit.advancejunittest;

public class PasswordValidator {

    // Checks if the password is at least 8 characters, has one uppercase letter, and one digit
    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasDigit = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }
        return hasUppercase && hasDigit;
    }
}