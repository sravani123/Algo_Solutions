package com.scheripa.solutions;

import java.util.Arrays;
import java.util.HashMap;

public class CheckAnagram {
	private boolean isAnagram(String firstString, String secondString) {
		firstString = firstString.toLowerCase();
		secondString = secondString.toLowerCase();
		if (firstString.length() != secondString.length()) {
			return false;
		}

		HashMap<Character, Integer> firstStringMap = new HashMap<>();
		char[] firstStringArray = firstString.toCharArray();
		char[] secondStringArray = secondString.toCharArray();

		for (int i = 0; i < firstStringArray.length; i++) {
			if (firstStringMap.containsKey(firstStringArray[i])) {
				int value = firstStringMap.get(firstStringArray[i]);
				value++;
				firstStringMap.put(firstStringArray[i], value);

			} else {
				firstStringMap.put(firstStringArray[i], 1);
			}
		}
		for (int i = 0; i < secondStringArray.length; i++) {
			if (!firstStringMap.containsKey(secondStringArray[i])) {
				return false;
			} else {
				int value = firstStringMap.get(secondStringArray[i]);
				value--;
				firstStringMap.put(secondStringArray[i], value--);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		CheckAnagram anagram = new CheckAnagram();
		boolean isAnagram = anagram.isAnagram("Sravani", "Sravani");
		int[] temp = new int[256];
		if (isAnagram) {
			System.out.println("Both the strings are Anagram");
		} else {
			System.out.println("Both the strings are not Anagram");
		}
	}
}
