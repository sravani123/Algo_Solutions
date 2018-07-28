package com.scheripa.solutions;

import java.util.Arrays;

public class SumofNumber {
//  [1,3,4,5]
//	[9,9,9]
//	[2,9,9]
	private int[] addOne(int[] givenArray) {
		int carry = 1;
		int[] result = new int[givenArray.length];
		for (int i = givenArray.length - 1; i >= 0; i--) {
			int total = givenArray[i] + carry;
			System.out.println("total"+total +"\n");
			if (total == 10) {
				carry = 1;
			} else {
				carry = 0;
			}
			result[i] = total % 10;
			System.out.println("carry value is ==="+carry);
			if (carry == 1 && i == 0) {
				System.out.println("in IF condition");
				result = new int[givenArray.length + 1];
				result[0] = result[i] +carry;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SumofNumber sum = new SumofNumber();
		int[] array = { 2,8,9 };
		int[] result = sum.addOne(array);
		System.out.println("result is ===>>>" + Arrays.toString(result));
	}
}
