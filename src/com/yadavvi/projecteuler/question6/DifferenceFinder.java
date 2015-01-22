package com.yadavvi.projecteuler.question6;

public class DifferenceFinder {
	private static final int MAX = 100;

	public static long computeDifference() {
		int result = MAX * (MAX + 1) / 2;
		result *= result;
		for (int i = 1; i <= MAX; i++) {
			result -= i * i;
		}
		return result;
	}

	private static long sumOfSquares(int limit) {
		// (1^2 + 2^2 + ... + n^2) = n*(n+1)*(2n+1)/6
		return limit * (limit + 1) * (2 * limit + 1) / 6;
	}

	private static long squareOfSums(int limit) {
		// (1 + 2 + ... + n)^2 = (n*(n+1)/2)^2
		return (limit * (limit + 1)) / 2 * (limit * (limit + 1)) / 2;
	}

	public static long computeDifferenceFormula(int limit) {
		return squareOfSums(limit) - sumOfSquares(limit);
	}
}
