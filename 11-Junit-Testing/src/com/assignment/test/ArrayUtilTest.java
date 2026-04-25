package com.assignment.test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.assignment.model.ArrayUtil;

class ArrayUtilTest {

    ArrayUtil util = new ArrayUtil();
    @Test
    void testNormalArray() {
        int[] input = {1, 2, 3};
        int[] expected = {3, 2, 1};

        assertArrayEquals(expected, util.reverseArray(input));
    }
    @Test
    void testSingleElement() {
        int[] input = {5};
        int[] expected = {5};

        assertArrayEquals(expected, util.reverseArray(input));
    }
    @Test
    void testEmptyArray() {
        int[] input = {};
        int[] expected = {};

        assertArrayEquals(expected, util.reverseArray(input));
    }
    @Test
    void testNullArray() {
        assertNull(util.reverseArray(null));
    }
}
