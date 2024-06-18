package com.bankuser.bankuser;

public class BankUser {
    private String userName;
    private double balance;

    // Constructor to initialize user with a name and initial balance
    public BankUser(String userName, double initialBalance) {
        this.userName = userName;
        this.balance = initialBalance;
    }

    // Get the user name
    public String getUserName() {
        return userName;
    }

    // Get the current balance
    public double getBalance() {
        return balance;
    }

    // Deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance");
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        BankUser user = new BankUser("John Doe", 1000);
        System.out.println("User: " + user.getUserName());
        System.out.println("Initial Balance: " + user.getBalance());

        user.deposit(500);
        System.out.println("Balance after deposit: " + user.getBalance());

        user.withdraw(200);
        System.out.println("Balance after withdrawal: " + user.getBalance());

        user.withdraw(1500); // Testing insufficient balance scenario
    }
}
