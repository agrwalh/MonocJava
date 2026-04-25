package com.assignment.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.assignment.model.Divide;

public class DivideTest {

	Divide divide = new Divide();

	@Test
	void shouldThrowExceptionWithMessageWhenDividingByZero() {

		ArithmeticException exception = assertThrows(ArithmeticException.class, () -> divide.divide(10, 0));

		// 🔹 Validate message
		assertEquals("Cannot divide by zero", exception.getMessage());
	}

	@ParameterizedTest(name = "shouldThrowExceptionWhenDividing {0} by {1}")
	@CsvSource({ "10, 0", "-10, 0", "0, 0", "999, 0" })
	void shouldThrowExceptionWithMessageWhenDividingByZero(int a, int b) {

		ArithmeticException ex = assertThrows(ArithmeticException.class, () -> divide.divide(a, b));

		// ✔ Validate message
		assertEquals("Cannot divide by zero", ex.getMessage());
	}
}
