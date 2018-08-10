package com.scheripa.solutions;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	private int solution(int[] input) {
		int k = 0;
		for (int i = 1; i < input.length; i++) {
			if (input[i] != input[k]) {
				k++;
				input[k] = input[i];

			}
		}
		return k+1;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray removeDuplicates = new RemoveDuplicatesFromSortedArray();
		int[] inputValues = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6 };
		int output = removeDuplicates.solution(inputValues);
		System.out.println("output===" +output);
	}

}
