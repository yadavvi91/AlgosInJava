package com.yadavvi.topcoder.question268;

import java.math.BigInteger;

public class LotteryUtils {

	public static BigInteger factorial(int n) {
		BigInteger factorial = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}

	public static BigInteger combination(int n, int r) {
		BigInteger rFactorial = BigInteger.ONE;
		BigInteger numeratorPart = BigInteger.ONE;

		for (int i = 0; i < r; i++) {
			numeratorPart = numeratorPart.multiply(BigInteger.valueOf(n - i));
		}

		rFactorial = factorial(r);

		return numeratorPart.divide(rFactorial);
	}

	public static BigInteger permutation(int n, int r) {
		return factorial(n).divide(factorial(n - r));
	}

}
