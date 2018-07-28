package com.scheripa.solutions;

import java.util.HashMap;
import java.util.Stack;

public class CheckBalancedString {
	HashMap<Character, Character> tokens = new HashMap<>();

	private boolean isBalanced(String s) {
		tokens.put('{', '}');
		tokens.put('[', ']');
		tokens.put('(', ')');
		Stack<Character> charStack = new Stack<>();
		char[] inputArray = s.toCharArray();
		for (int i = 0; i < inputArray.length; i++) {
			char c = inputArray[i];
			if (tokens.keySet().contains(c)) {
				charStack.push(c);
			} else if (tokens.values().contains(c) && tokens.get(charStack.peek()) == c) {
				charStack.pop();

			} else {
				return false;
			}
		}
		return charStack.isEmpty();
	}

	public static void main(String[] args) {
		CheckBalancedString checkString = new CheckBalancedString();
		boolean result = checkString.isBalanced("{[()()]()}");
		System.out.println("result" + result);
	}
}
