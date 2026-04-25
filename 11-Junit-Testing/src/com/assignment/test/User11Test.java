package com.assignment.test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.assignment.model.User11;

class UserTest11 {

	User11 user;

	@BeforeEach
	void setup() {
		user = new User11("Harsh", 20);
		System.out.println("Setup done");
	}

	@AfterEach
	void teardown() {
		user = null;
		System.out.println("Cleanup done");
	}

	@Test
	void testValidUser() {
		assertTrue(user.isValid());
	}

	@Test
	void testNullName() {
		user = new User11(null, 20);
		assertFalse(user.isValid());
	}

	@Test
	void testInvalidAge() {
		user = new User11("Harsh", -5);
		assertFalse(user.isValid());
	}
}