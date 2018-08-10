package com.scheripa.solutions;

import java.awt.List;
import java.util.ArrayList;

public class SumofThreeNumbers {
//	o(n^3)
	private String findTriplet(int[] inputArray, int targetSum) {

		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i + 1; j < inputArray.length; j++) {
				for (int k = j + 1; k < inputArray.length; k++) {
					if (inputArray[i] + inputArray[j] + inputArray[k] == targetSum) {
						return "FIRST VALUE IS===" + inputArray[i] + "\nSECOND VALUE IS===" + inputArray[j]
								+ "\nTHIRD VALUE IS===" + inputArray[k];
					}
				}

			}
		}
		return "Not FOUND";
	}

//	O(n^2)
	private ArrayList<ArrayList<Integer>> findThreeSum(int[] input, int targetSum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < input.length; i++) {
			int left = i + 1;
			int right = input.length - 1;
			while (left < right) {
				ArrayList<Integer> result1 = new ArrayList<Integer>();

				if (input[left] + input[right] + input[i] == targetSum) {
					result1.add(input[left]);
					result1.add(input[right]);
					result1.add(input[i]);
					result.add(result1);

				}
				int leftValue = input[left];
				int rightValue = input[right];
				while (left+1 < input.length && leftValue == input[leftValue]) {
					left++;
				}
				while (right-1 > i && rightValue == input[rightValue]) {
					right--;
				}
				if (targetSum < input[right]) {
					right--;
				}
				if (targetSum > input[left]) {
					left++;
				}
			}

		}
		return result;

	}

	public static void main(String[] args) {
		SumofThreeNumbers sumOfThreeObj = new SumofThreeNumbers();
//		int[] inputArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] inputArray = { 7, 8, 13, 20, 18, 3, 6, 1, 11 };

//		String result = sumOfThreeObj.findTriplet(inputArray, 20);
		ArrayList<ArrayList<Integer>> result = sumOfThreeObj.findThreeSum(inputArray, 20);

		System.out.println(result);
	}
}
