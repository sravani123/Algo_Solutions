package com.scheripa.solutions;

public class FindElementinCircularSortArray {
	int rotated_binary_search(int A[], int N, int key) {
		int L = 0;
		int R = N - 1;

		while (L <= R) {
			// Avoid overflow, same as M=(L+R)/2
			int M = L + ((R - L) / 2);
			if (A[M] == key)
				return M;

			// the bottom half is sorted
			if (A[L] <= A[M]) {
				System.out.println("Left element is ===" + A[L] + "key is==" + key + "Median is ===" + A[M]);
				if (A[L] <= key && key < A[M]) {
					R = M - 1;
					System.out.println("R value is ====" + R);
				} else {
					L = M + 1;
					System.out.println("L value is ====" + L);

				}
			}
			// the upper half is sorted
			else {

				if (A[M] < key && key <= A[R])
					L = M + 1;
				else
					R = M - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FindElementinCircularSortArray findElementPosition = new FindElementinCircularSortArray();
		int[] input = { 4, 5, 6, 7, 0, 1, 2 };
		findElementPosition.rotated_binary_search(input, 7, 2);
	}
}
