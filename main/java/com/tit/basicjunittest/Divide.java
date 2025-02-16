package com.tit.basicjunittest;

public class Divide {

    // Divide a by b and throw exception if b is zero
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Divide divide=new Divide();
        System.out.println(divide.divide(4,2));
    }
}