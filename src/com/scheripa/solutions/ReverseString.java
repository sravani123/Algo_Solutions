package com.scheripa.solutions;

public class ReverseString {

	private String reverse(String text) {
		char[] charArray = text.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = charArray.length - 1; i >= 0; i--) {
			sb.append(charArray[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ReverseString str = new ReverseString();
		String result = str.reverse("SRAVANI");
		System.out.println("result is ===>>>" + result);
	}
}
