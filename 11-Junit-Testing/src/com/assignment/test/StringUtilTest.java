package com.assignment.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import com.assignment.model.StringUtility;

public class StringUtilTest {

	StringUtility util = new StringUtility();

	// 🔹 isEmpty
	@ParameterizedTest
	@CsvSource({ "'', true", "'   ', true", "hello, false" })
	void shouldCheckIfStringIsEmpty(String input, boolean expected) {
		assertEquals(expected, util.isEmpty(input));
	}

	@ParameterizedTest
	@NullSource
	void shouldReturnTrueWhenInputIsNull(String input) {
		assertTrue(util.isEmpty(input));
	}

	// 🔹 toUpperCase
	@ParameterizedTest
	@CsvSource({ "hello, HELLO", "HELLO, HELLO" })
	void shouldConvertToUpperCase(String input, String expected) {
		assertEquals(expected, util.toUpperCase(input));
	}

	@ParameterizedTest
	@NullSource
	void shouldReturnNullWhenInputIsNull(String input) {
		assertNull(util.toUpperCase(input));
	}

	// 🔹 getLength
	@ParameterizedTest
	@CsvSource({ "hello, 5", "'', 0", "'   ', 3" })
	void shouldReturnCorrectLength(String input, int expected) {
		assertEquals(expected, util.getLength(input));
	}

	@ParameterizedTest
	@NullSource
	void shouldReturnZeroWhenInputIsNull(String input) {
		assertEquals(0, util.getLength(input));

//    @Test
//    void testIsEmpty() {
//
//        // null
//        assertTrue(util.isEmpty(null));
//
//        // empty string
//        assertTrue(util.isEmpty(""));
//
//        // whitespace
//        assertTrue(util.isEmpty("   "));
//
//        // normal string
//        assertFalse(util.isEmpty("hello"));
//    }
//    @Test
//    void testToUpperCase() {
//
//        // normal
//        assertEquals("HELLO", util.toUpperCase("hello"));
//
//        // already upper
//        assertEquals("HELLO", util.toUpperCase("HELLO"));
//
//        // null
//        assertNull(util.toUpperCase(null));
//    }
//    @Test
//    void testGetLength() {
//
//        // normal
//        assertEquals(5, util.getLength("hello"));
//
//        // empty
//        assertEquals(0, util.getLength(""));
//
//        // whitespace
//        assertEquals(3, util.getLength("   "));
//
//        // null
//        assertEquals(0, util.getLength(null));
	}
}
