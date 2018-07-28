package com.scheripa.solutions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FibonacciSeries {
	private int getFibN(int n) {
		// TODO Auto-generated method stub
		int[] fibSeries = new int[n+1];
		System.out.println("fib series ===="+n);
		fibSeries[0] = 0;
		fibSeries[1] = 1;
		fibSeries[2] = 1;
		if (n == 1 || n == 2) {
			return 1;
		}
		for (int i = 3; i < n+1; i++) {
			fibSeries[i] = fibSeries[i-1]+fibSeries[i-2];

		}
		System.out.println("n value is =="+Arrays.toString(fibSeries));
		
		return fibSeries[n];
	}

	public static void main(String[] args) {
		FibonacciSeries fib = new FibonacciSeries();
		fib.getFibN(5);
		System.out.println(""+fib.getFibN(9));
	}

}
