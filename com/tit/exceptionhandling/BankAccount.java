package com.tit.exceptionhandling;

import java.util.Scanner;

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException , IllegalArgumentException {
        // Check for the negative amount
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        // Check for insufficient balance
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        // Perform withdrawal
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BankAccount account = new BankAccount(1000.00); // Initial balance of 1000
        System.out.println();
        System.out.println("Enter withdraw amount: ");
        double amountToWithdraw = sc.nextDouble(); // Amount to withdraw
        try {
            account.withdraw(amountToWithdraw); // Attempt to withdraw
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage()); // Handle insufficient balance
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Handle invalid amount
        }
    }
}
