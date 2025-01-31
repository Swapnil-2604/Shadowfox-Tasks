package com.bams.bank;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {
	  private String accountHolderName;
	    private String accountNumber;
	    private double balance;
	    private List<String> transactionHistory;

	    // Constructor8
	    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
	        if (initialBalance < 0) {
	            throw new IllegalArgumentException("Initial balance cannot be negative");
	        }
	        this.accountHolderName = accountHolderName;
	        this.accountNumber = accountNumber;
	        this.balance = initialBalance;
	        this.transactionHistory = new ArrayList<>();
	        logTransaction("Account created with balance: " + initialBalance);
	    }

	    // Getters
	    public String getAccountHolderName() {
	        return accountHolderName;
	    }

	    public String getAccountNumber() {
	        return accountNumber;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public List<String> getTransactionHistory() {
	        return transactionHistory;
	    }

	    // Deposit method
	    public void deposit(double amount) {
	        if (amount <= 0) {
	            throw new IllegalArgumentException("Deposit amount must be positive");
	        }
	        balance += amount;
	        logTransaction("Deposited: " + amount);
	    }

	    // Withdrawal method
	    public void withdraw(double amount) {
	        if (amount <= 0) {
	            throw new IllegalArgumentException("Withdrawal amount must be positive");
	        }
	        if (amount > balance) {
	            throw new IllegalArgumentException("Insufficient balance");
	        }
	        balance -= amount;
	        logTransaction("Withdrew: " + amount);
	    }

	    // Utility method to log transactions with timestamps
	    private void logTransaction(String transactionDetail) {
	        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	        transactionHistory.add(timestamp + " - " + transactionDetail);
	    }

	    // Display account details
	    public void displayAccountDetails() {
	        System.out.println("Account Holder: " + accountHolderName);
	        System.out.println("Account Number: " + accountNumber);
	        System.out.println("Current Balance: " + balance);
	    }
}
