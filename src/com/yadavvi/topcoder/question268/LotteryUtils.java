package com.yadavvi.topcoder.question268;

import java.math.BigInteger;

public class LotteryUtils {
	private static BigInteger getPow(int n, int r) {
		BigInteger noOfDraws = new BigInteger("1");
		for (int i = 0; i < r; i++) {
			noOfDraws = noOfDraws.multiply(BigInteger.valueOf(n));
		}
		return noOfDraws;
	}

	private static BigInteger getFactorial(int n) {
		BigInteger factorial = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}

	public static BigInteger getCombination(int n, int r) {
		BigInteger rFactorial = new BigInteger("1");
		BigInteger numeratorPart = new BigInteger("1");

		if (n == r)
			return new BigInteger("1");

		for (int i = 0; i < r; i++) {
			numeratorPart = numeratorPart.multiply(BigInteger.valueOf(n - i));
		}

		rFactorial = getFactorial(r);

		return numeratorPart.divide(rFactorial);
	}

	public static BigInteger getPermutation(int n, int r) {
		if (n == r)
			return getFactorial(n);
		else
			return getFactorial(n).divide(getFactorial(n - r));
	}

	public static BigInteger getNoOfDrawsForNotSortedNotUnique(int n, int r) {
		return getPow(n, r);
	}

	public static BigInteger getNoOfDrawsForSortedNotUnique(int n, int r) {
		// SEE: Stars and Bars (Combinatorics)
		return getCombination(n + r - 1, r);
	}

	public static BigInteger getNoOfDrawsForNotSortedUnique(int n, int r) {
		return getPermutation(n, r);
	}

	public static BigInteger getNoOfDrawsForSortedUnique(int n, int r) {
		return getCombination(n, r);
	}

}
