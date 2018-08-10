package com.scheripa.solutions;

public class RomanToInt {
	public int romanToInt(String s) {
		if (s == null || s.isEmpty())
			return 0;

		if (s.length() < 2)
			return getValue(s.substring(0));
		switch (s.charAt(0)) {
		case 'I':
			switch (s.charAt(1)) {
			case 'V':
				return 4 + romanToInt(s.substring(2));
			case 'X':
				return 9 + romanToInt(s.substring(2));
			default:
				return 1 + romanToInt(s.substring(1));
			}
		case 'X':
			switch (s.charAt(1)) {
			case 'L':
				return 40 + romanToInt(s.substring(2));
			case 'C':
				return 90 + romanToInt(s.substring(2));
			default:
				return 10 + romanToInt(s.substring(1));
			}
		case 'C':
			switch (s.charAt(1)) {
			case 'D':
				return 400 + romanToInt(s.substring(2));
			case 'M':
				return 900 + romanToInt(s.substring(2));
			default:
				return 100 + romanToInt(s.substring(1));
			}
		default:
			return getValue(s.substring(0, 1)) + romanToInt(s.substring(1));
		}
	}

	public int getValue(String s) {
		if (s.equals("I")) {
			return 1;
		}
		if (s.equals("V")) {
			return 5;
		}
		if (s.equals("X")) {
			return 10;
		}
		if (s.equals("L")) {
			return 50;
		}
		if (s.equals("C")) {
			return 100;
		}
		if (s.equals("D")) {
			return 500;
		}
		if (s.equals("M")) {
			return 1000;
		}

		return 0;
	}

	public static void main(String[] args) {
		RomanToInt rtoi = new RomanToInt();
		int result = rtoi.romanToInt("MCXCIV");
		String s = "sravani";
		System.out.println(""+s.substring(1));
		System.out.println(result);
	}
}
