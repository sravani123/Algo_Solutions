package com.scheripa.solutions;

import java.util.ArrayList;

class InterleaveList {
	private void getInterleaveList() {
		int[][] input = { { 1, 2, 3,4 }, { 0, 9,6 }, { 5,7 }, { 8,4, 6, 7, 8, 67,89,54,76 } };
//	   expected output is === [1, 0, 5, 8, 2, 9, 7, 4, 3, 6, 6, 4, 7, 8, 67, 89, 54, 76]
		ArrayList<Integer> output = new ArrayList();
		int j = 0;
		boolean shouldVisit = true;
		while (shouldVisit) {
			for (int i = 0; i < input.length; i++) {
				int[] arrayAtindex = input[i];
				if (j < arrayAtindex.length) {
					shouldVisit= true;
					output.add(arrayAtindex[j]);
				}else {
					shouldVisit=false;
				}
			}
			j++;
		}
		System.out.println("output===>" + output);
	}

	public static void main(String[] args) {
		InterleaveList interLeaveList = new InterleaveList();
		interLeaveList.getInterleaveList();
	}
}
