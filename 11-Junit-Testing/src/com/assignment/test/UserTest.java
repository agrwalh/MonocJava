package com.assignment.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import com.assignment.model.User;

class UserTest {

	User user;

	@BeforeEach
	void setup() {
		user = new User("Joe", 22);
	}

	@AfterEach
	void tearDown() {
		user = null;
	}

	@Test
	void testValidUser() {
		assertEquals("Joe", user.getName());
		assertEquals(22, user.getAge());
	}
	
	
    @ParameterizedTest
    @CsvSource({
        "Harsh, -1",
        "John, 0"
    })
    void shouldThrowExceptionWhenAgeIsInvalid(String name, int age) {
        assertThrows(IllegalArgumentException.class, () -> {
            new User(name, age);
        });
    }

    // ❌ Null name
    @ParameterizedTest
    @NullSource
    void shouldThrowExceptionWhenNameIsNull(String name) {
        assertThrows(IllegalArgumentException.class, () -> {
            new User(name, 22);
        });

//	@Test
//	void testNullName() {
//		assertThrows(IllegalArgumentException.class, () -> {
//			new User(null, 22);
//		});
//	}
	 
//	@Test
//	void testInvalidAge() {
//		assertThrows(IllegalArgumentException.class, () -> {
//			new User("Harsh", -1);
//		});
	}
}

