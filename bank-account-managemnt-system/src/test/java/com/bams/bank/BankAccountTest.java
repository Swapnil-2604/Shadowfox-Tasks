package com.bams.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BankAccountTest {
	 @Test
	    void testAccountCreation() {
	        BankAccount account = new BankAccount("John Doe", "1234567890", 1000);
	        assertEquals("John Doe", account.getAccountHolderName());
	        assertEquals("1234567890", account.getAccountNumber());
	        assertEquals(1000, account.getBalance());
	        assertEquals(1, account.getTransactionHistory().size());
	    }

	    @Test
	    void testDeposit() {
	        BankAccount account = new BankAccount("John Doe", "1234567890", 1000);
	        account.deposit(500);
	        assertEquals(1500, account.getBalance());
	        assertTrue(account.getTransactionHistory().get(1).contains("Deposited: 500"));
	    }

	    @Test
	    void testWithdraw() {
	        BankAccount account = new BankAccount("John Doe", "1234567890", 1000);
	        account.withdraw(300);
	        assertEquals(700, account.getBalance());
	        assertTrue(account.getTransactionHistory().get(1).contains("Withdrew: 300"));
	    }

	    @Test
	    void testWithdrawInsufficientBalance() {
	        BankAccount account = new BankAccount("John Doe", "1234567890", 1000);
	        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(1500));
	        assertEquals("Insufficient balance", exception.getMessage());
	    }

	    @Test
	    void testNegativeDeposit() {
	        BankAccount account = new BankAccount("John Doe", "1234567890", 1000);
	        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.deposit(-500));
	        assertEquals("Deposit amount must be positive", exception.getMessage());
	    }

	    @Test
	    void testNegativeWithdrawal() {
	        BankAccount account = new BankAccount("John Doe", "1234567890", 1000);
	        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-500));
	        assertEquals("Withdrawal amount must be positive", exception.getMessage());
	    }

	    @Test
	    void testTransactionHistory() {
	        BankAccount account = new BankAccount("John Doe", "1234567890", 1000);
	        account.deposit(500);
	        account.withdraw(200);
	        List<String> history = account.getTransactionHistory();
	        assertEquals(3, history.size());
	        assertTrue(history.get(1).contains("Deposited: 500"));
	        assertTrue(history.get(2).contains("Withdrew: 200"));
	    }
}
