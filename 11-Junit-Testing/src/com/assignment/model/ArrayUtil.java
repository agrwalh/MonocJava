package com.assignment.model;

public class ArrayUtil {
	public int[] reverseArray(int[] arr) {

        if (arr == null) return null;

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }

        return result;
    }
}
