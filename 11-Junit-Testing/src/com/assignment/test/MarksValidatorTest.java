package com.assignment.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.assignment.model.MarksValidator;

class MarksValidatorTest {

	MarksValidator validator = new MarksValidator();

	@ParameterizedTest
	@CsvSource({ 
		"0, true", 
		"1, true",
		"99, true",
		"100, true", 
		"-1, false",
		"101, false" })
	void shouldValidateMarksAtBoundary(int marks, boolean expected) {
		assertEquals(expected, validator.isValidMarks(marks));
	}
}
