package com.bams.bank;

public class main {
	public static void main(String[] args) {
		BankAccount account = new BankAccount("John Doe", "1234567890", 1000);

		account.deposit(500);
		account.withdraw(300);

		System.out.println("Account Holder: " + account.getAccountHolderName());
		System.out.println("Account Number: " + account.getAccountNumber());
		System.out.println("Current Balance: " + account.getBalance());
		System.out.println("Transaction History:");
		account.getTransactionHistory().forEach(System.out::println);
	}
}
