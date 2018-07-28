package com.scheripa.solutions;

public class ReplaceSpace {

	private char[] replaceFun(String s) {
		System.out.println("Lemnght of the string is ===" + s.length());
		int length = s.length();
		int numOfSpaces = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				numOfSpaces++;
			}
		}
		int newLength = length + numOfSpaces * 2;
		char[] s1 = new char[newLength];
		char[] str = s.toCharArray();
		System.out.println("str is" + str);

		s1[newLength-1] = '\0';
		for (int j = length - 1; j >= 0; j--) {
			if (str[j] == ' ') {
				s1[newLength - 1] = '0';
				s1[newLength - 2] = '2';
				s1[newLength - 3] = '%';
				newLength = newLength - 3;
				
			} else {
				s1[newLength-1] = str[j];
				newLength = newLength - 1;
			}

		}
		System.out.println(s1);
		return s1;
	}

	public static void main(String[] args) {
		ReplaceSpace replaceSpace = new ReplaceSpace();
		char[] result = replaceSpace.replaceFun("Sra vani Lik");
		System.out.println("result is ===>>>" + result);

	}

}
