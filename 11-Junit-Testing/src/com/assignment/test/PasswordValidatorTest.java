package com.assignment.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.assignment.model.PasswordValidator;

class PasswordValidatorTest {

	PasswordValidator validator = new PasswordValidator();

	@ParameterizedTest
	@ValueSource(strings = { "Abcd1234", "Xyz98765" })
	void shouldReturnTrueForValidPasswords(String input) {
		assertTrue(validator.isValid(input));
	}

	@ParameterizedTest
	@ValueSource(strings = { "Abc12", "abcd1234", "Abcdefgh" })
	void shouldReturnFalseForInvalidPasswords(String input) {
		assertFalse(validator.isValid(input));
	}

	@ParameterizedTest
	@NullAndEmptySource
	void shouldReturnFalseForNullOrEmpty(String input) {
		assertFalse(validator.isValid(input));
	}

//    @Test
//    void shouldReturnTrueWhenPasswordIsValid() {
//        assertTrue(validator.isValid("Abcd1234"));
//    }
//    @Test
//    void shouldReturnFalseWhenPasswordIsTooShort() {
//        assertFalse(validator.isValid("Abc12"));
//    }
//    @Test
//    void shouldReturnFalseWhenNoUppercase() {
//        assertFalse(validator.isValid("abcd1234"));
//    }
//    @Test
//    void shouldReturnFalseWhenNoNumber() {
//        assertFalse(validator.isValid("Abcdefgh"));
//    }
//    @Test
//    void shouldReturnFalseWhenPasswordIsNull() {
//        assertFalse(validator.isValid(null));
//    }
//    @Test
//    void shouldReturnFalseWhenPasswordIsEmpty() {
//        assertFalse(validator.isValid(""));
}
