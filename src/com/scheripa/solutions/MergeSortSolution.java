package com.scheripa.solutions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortSolution {
	public void mergeSort(int[] inputArray) {
		int leftStart = 0;
		mergeSort(inputArray, new int[inputArray.length], leftStart, inputArray.length - 1);

	}

	private void mergeSort(int[] inputArray, int[] temp, int leftStart, int rightEnd) {
		// TODO Auto-generated method stub
		if (leftStart >= rightEnd) {
			return;
		}
		int middle = (leftStart + rightEnd) / 2;
		mergeSort(inputArray, temp, leftStart, middle);
		mergeSort(inputArray, temp, middle + 1, rightEnd);
		mergeHalves(inputArray, temp, leftStart, rightEnd);

	}

	private void mergeHalves(int[] inputArray, int[] temp, int leftStart, int rightEnd) {
		// TODO Auto-generated method stub
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		while (left <= leftEnd && right <= rightEnd) {
			if (inputArray[left] <= inputArray[right]) {
				temp[index] = inputArray[left];
				left++;
			} else {
				temp[index] = inputArray[right];
				right++;
			}
			index++;
		}
		System.arraycopy(inputArray, left, temp, index, leftEnd  - left + 1);
		System.arraycopy(inputArray, right, temp, index, rightEnd  - right + 1);
		System.arraycopy(temp, leftStart, inputArray,  leftStart  ,size);

		System.out.println(Arrays.toString(temp));
	}

	public static void main(String[] args) {
		MergeSortSolution sol = new MergeSortSolution();
		int[] input = {1,8,9,5};
		sol.mergeSort(input);

	}

}
