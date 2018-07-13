package com.scheripa.solutions;

public class ReverseNumber {

	public int reverse(int number) {

		int prev_num = 0;
		int rev_num = 0;
		while (number != 0) {
			int current = number % 10;
			rev_num = rev_num * 10 + current;
			// checking if the reverse overflowed or not.
			// The values of (rev_num - curr_digit)/10 and
			// prev_rev_num must be same if there was no
			// problem.
			if ((rev_num - current) / 10 != prev_num) {
				return 0;
			}
			prev_num = rev_num;
			number = number / 10;
		}

		return rev_num;
	}

	public static void main(String[] args) {
		ReverseNumber reverseNumber = new ReverseNumber();
		int result = reverseNumber.reverse(12345);
		System.out.println("Reverse Number is ===" + result + "\n");

	}
}
