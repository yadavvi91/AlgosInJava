package com.yadavvi.topcoder.question268;

import java.util.StringTokenizer;

public class Lottery {

	private static class Rule {
		String name;
		String[] conditions;

		public Rule(String name, String[] conditions) {
			this.name = name;
			this.conditions = conditions;
		}
	}

	public static String[] sortByOdds(String[] rules) {
		Rule[] rule = new Rule[4];
		StringBuilder strBuilder = new StringBuilder();

		for (int i = 0; i < rules.length; i++) {
			rule[i] = parseStringAndCreateRule(rules[i]);

			// Print the Rules
			strBuilder.setLength(0);
			strBuilder.append(rule[i].name + ": ");
			for (String indRule : rule[i].conditions) {
				strBuilder.append(indRule + ", ");
			}
			strBuilder.delete(strBuilder.length() - 2, strBuilder.length() - 1);
			System.out.println(strBuilder.toString());
		}

		return new String[] { "" };
	}

	private static Rule parseStringAndCreateRule(String rule) {
		StringTokenizer strTokenizer = new StringTokenizer(rule, ":");

		String name = strTokenizer.nextToken().trim();
		String[] conditions = strTokenizer.nextToken().trim().split(" ");

		return new Rule(name, conditions);
	}

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

		for (int i = 0; i < r; i++) {
			numeratorPart *= (n - i);
		}

		rFactorial = getFactorial(r);

		return numeratorPart / rFactorial;
	}

	public static long getPermutation(int n, int r) {
		return getFactorial(n) / getFactorial(n - r);
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
