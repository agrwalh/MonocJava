package com.assignment.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.assignment.model.BankAccount;

class BankAccountTest {

	BankAccount account;

	@BeforeEach
	void setup() {
		account = new BankAccount(1000); // har test fresh start
	}

	@AfterEach
	void tearDown() {
		account = null;
	}


	@ParameterizedTest
	@CsvSource({ "1000, 500, 1500", "1000, 0, 1000" })
	void shouldUpdateBalanceAfterDeposit(double initial, double deposit, double expected) {
		account = new BankAccount(initial);
		account.deposit(deposit);
		assertEquals(expected, account.getBalance());
	}


	@ParameterizedTest
	@CsvSource({ "1000, 400, 600", "500, 500, 0" })
	void shouldUpdateBalanceAfterWithdraw(double initial, double withdraw, double expected) {
		account = new BankAccount(initial);
		account.withdraw(withdraw);
		assertEquals(expected, account.getBalance());
	}


	@ParameterizedTest
	@CsvSource({ "1000, -50", "1000, 2000" })
	void shouldThrowExceptionForInvalidWithdraw(double initial, double amount) {
		account = new BankAccount(initial);

		assertThrows(IllegalArgumentException.class, () -> {
			account.withdraw(amount);
		});
	}

	
	@ParameterizedTest
	@CsvSource({ "1000, -100" })
	void shouldThrowExceptionForInvalidDeposit(double initial, double amount) {
		account = new BankAccount(initial);

		assertThrows(IllegalArgumentException.class, () -> {
			account.deposit(amount);
		});
	}

	@Test
	void shouldHandleMultipleTransactionsCorrectly() {
		account.deposit(500); // 1500
		account.withdraw(200); // 1300

		assertEquals(1300, account.getBalance());
//	@Test
//	void testDeposit() {
//		account.deposit(500);
//		assertEquals(1500, account.getBalance());
//	}
//
//	@Test
//	void testWithdraw() {
//		account.withdraw(400);
//		assertEquals(600, account.getBalance());
//	}
//
//	@Test
//	void testInsufficientBalance() {
//		assertThrows(IllegalArgumentException.class, () -> {
//			account.withdraw(2000);
//		});
//	}
//
//	@Test
//	void testInvalidWithdraw() {
//		assertThrows(IllegalArgumentException.class, () -> {
//			account.withdraw(-50);
//		});
//	}
//
//	@Test
//	void testMultipleTransactions() {
//		account.deposit(500); // 1500
//		account.withdraw(200); // 1300
//
//		assertEquals(1300, account.getBalance());
	}
}
