package com.assignment.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.assignment.model.Calculator;

class CalculatorTest {

	Calculator calc = new Calculator();

	// 🔹 ADD
	@ParameterizedTest
	@CsvSource({ "2, 3, 5", "-2, -3, -5", "-2, 3, 1", "0, 5, 5", "-2, 2, 0" })
	void shouldReturnCorrectSum(int a, int b, int expected) {
		assertEquals(expected, calc.add(a, b));
	}

	// 🔹 ADD
	@ParameterizedTest
	@CsvSource({ "3, 2, 1", "-1, -3, 2", "2, 2, 0", "0, 5, -5", "-2, 2, -4" })
	void shouldReturnCorrectSub(int a, int b, int expected) {
		assertEquals(expected, calc.subtract(a, b));
	}

	// 🔹 MULTIPLY
	@ParameterizedTest
	@CsvSource({ "6, 4, 24", "-8, -4, 32", "5, 0, 0", "-3, 2, -6" })
	void shouldReturnCorrectProduct(int a, int b, int expected) {
		assertEquals(expected, calc.multiply(a, b));
	}

	// 🔹 DIVIDE
	@ParameterizedTest
	@CsvSource({ "16, 4, 4", "0, 5, 0", "-10, 2, -5" })
	void shouldReturnCorrectQuotient(int a, int b, int expected) {
		assertEquals(expected, calc.divide(a, b));
	}
}