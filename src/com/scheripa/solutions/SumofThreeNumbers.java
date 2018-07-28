package com.scheripa.solutions;

public class SumofThreeNumbers {
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

	public static void main(String[] args) {
		SumofThreeNumbers sumOfThreeObj = new SumofThreeNumbers();
		int[] inputArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
		String result = sumOfThreeObj.findTriplet(inputArray, 20);
		System.out.println(result);
	}
}
