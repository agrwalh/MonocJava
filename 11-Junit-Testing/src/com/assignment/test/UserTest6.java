package com.assignment.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.assignment.model.User6;

class UserTest6 {

	@ParameterizedTest
	@CsvSource({ 
		"Harsh, 22, ACTIVE", 
		"John, 30, INACTIVE", 
		"Alice, 25, ACTIVE" 
		})
	void shouldValidateUserProperties(String name, int age, String status) {

		User6 user = new User6(name, age, status);

		assertAll("User Properties",
				() -> assertEquals(name, user.getName()), 
				() -> assertEquals(age, user.getAge()),
				() -> assertEquals(status, user.getStatus()));

//	@Test
//	void testUserProperties() {
//
//		User6 user = new User6("Harsh", 22, "ACTIVE");
//
//		assertAll("User Properties",
//				() -> assertEquals("Harsh", user.getName()), 
//				() -> assertEquals(22, user.getAge()),
//				() -> assertEquals("ACTIVE", user.getStatus()));
	}
}