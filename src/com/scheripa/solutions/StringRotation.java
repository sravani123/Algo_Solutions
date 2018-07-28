package com.scheripa.solutions;

public class StringRotation {
	public int isRotation(String s1, String s2) {
		int len = s1.length();
		/* check that s1 and s2 are equal length and not empty */
		if (len == s2.length() && len > 0) {
			/* concatenate s1 and s1 within new buffer */
			String s1s1 = s1 + s1;
			return s2.indexOf(s1s1);
		}
		return 0;
	}

	public static void main(String[] args) {
		StringRotation checkRotation = new StringRotation();
		int isRotation = checkRotation.isRotation("ABCD", "BCAD");
		if (isRotation == -1) {
			System.out.println("Strings are rotations of each other");
		}else {
			System.out.println("Strings are not rotations of each other");

		}

	}

}
