package com.yadavvi.topcoder.question268;

public class LotteryUtils {
	private static long getPow(int n, int r) {
		long noOfDraws = 1;
		for (int i = 0; i < r; i++) {
			noOfDraws *= n;
		}
		return noOfDraws;
	}

	private static long getFactorial(int n) {
		long factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public static long getCombination(int n, int r) {
		long rFactorial = 1;
		long numeratorPart = 1;

		if (n == r)
			return 1;

		for (int i = 0; i < r; i++) {
			numeratorPart *= (n - i);
		}

		rFactorial = getFactorial(r);

		return numeratorPart / rFactorial;
	}

	public static long getPermutation(int n, int r) {
		if (n == r)
			return getFactorial(n);
		else {
			System.out.println("Factorial n-r: " + getFactorial(n - r));
			return getFactorial(n) / getFactorial(n - r);
		}
	}

	public static long getNoOfDrawsForNotSortedNotUnique(int n, int r) {
		return getPow(n, r);
	}

	public static long getNoOfDrawsForSortedNotUnique(int n, int r) {
		return getNoOfDrawsForNotSortedNotUnique(n, r)
				- getNoOfDrawsForSortedUnique(n, r);
	}

	public static long getNoOfDrawsForNotSortedUnique(int n, int r) {
		return getPermutation(n, r);
	}

	public static long getNoOfDrawsForSortedUnique(int n, int r) {
		return getCombination(n, r);
	}

}
