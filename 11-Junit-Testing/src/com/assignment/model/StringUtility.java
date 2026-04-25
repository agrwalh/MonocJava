package com.assignment.model;

public class StringUtility {
	

	    public boolean isEmpty(String s) {
	        if (s == null) return true;
	        return s.trim().isEmpty();
	    }

	    public String toUpperCase(String s) {
	        if (s == null) return null;
	        return s.toUpperCase();
	    }

	    public int getLength(String s) {
	        if (s == null) return 0;
	        return s.length();
	    }
}
