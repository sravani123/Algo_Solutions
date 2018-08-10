package com.scheripa.solutions;

public class IsStringPolindromWithoutSpecialChars {
	private boolean isPolindrom(String input) {
		char[] inputArray = input.toCharArray();
		int start = 0;
		int end = input.length() - 1;
		while (start < end) {
			if (!Character.isLetterOrDigit(inputArray[start])) {
				start++;
				continue;
			}
			if (!Character.isLetterOrDigit(inputArray[end])) {
				end--;
				continue;
			}
			if (inputArray[start] != inputArray[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;

	}

	public static void main(String[] args) {
		IsStringPolindromWithoutSpecialChars obj = new IsStringPolindromWithoutSpecialChars();
		boolean result = obj.isPolindrom("L&*E(())(VEL");
		System.out.println(result);
	}

}
