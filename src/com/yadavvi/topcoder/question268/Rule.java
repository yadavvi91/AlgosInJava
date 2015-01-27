package com.yadavvi.topcoder.question268;

import java.math.BigInteger;

import javax.naming.directory.InvalidAttributesException;

public class Rule implements Comparable<Rule> {

	String name;
	String[] conditions;
	int noOfChoices;
	int noOfBlanks;
	boolean isSorted;
	boolean isUnique;
	BigInteger numberOfOdds;

	public Rule(String name, String[] conditions) {
		this.name = name;
		this.conditions = conditions;
		checkAndAssignConditions(conditions);
		calculateOdds();
	}

	private void checkAndAssignConditions(String[] conditions) {
		try {
			if (conditions.length != 4) {
				throw new IllegalArgumentException(
						"Number of conditions should be 4");
			}

			noOfChoices = Integer.valueOf(conditions[0]);
			noOfBlanks = Integer.valueOf(conditions[1]);
			if (conditions[2].length() != 1 || conditions[3].length() != 1) {
				throw new InvalidAttributesException(
						"Conditions Sorted and Unique should be of length 1");
			}

			if (String.valueOf(conditions[2]).equalsIgnoreCase("T")) {
				isSorted = true;
			} else if (String.valueOf(conditions[2]).equalsIgnoreCase("F")) {
				isSorted = false;
			} else {
				throw new InvalidAttributesException(
						"Sorted should either be TRUE of FALSE");
			}

			if (String.valueOf(conditions[3]).equalsIgnoreCase("T")) {
				isUnique = true;
			} else if (String.valueOf(conditions[3]).equalsIgnoreCase("F")) {
				isUnique = false;
			} else {
				throw new InvalidAttributesException(
						"Unique should either be TRUE of FALSE");
			}

		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (InvalidAttributesException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public static BigInteger getNoOfDrawsForNotSortedNotUnique(int n, int r) {
		return BigInteger.valueOf(n).pow(r);
	}

	public static BigInteger getNoOfDrawsForSortedNotUnique(int n, int r) {
		// SEE: Stars and Bars (Combinatorics)
		return LotteryUtils.combination(n + r - 1, r);
	}

	public static BigInteger getNoOfDrawsForNotSortedUnique(int n, int r) {
		return LotteryUtils.permutation(n, r);
	}

	public static BigInteger getNoOfDrawsForSortedUnique(int n, int r) {
		return LotteryUtils.combination(n, r);
	}

	private void calculateOdds() {
		if (!isSorted && !isUnique) {
			numberOfOdds = getNoOfDrawsForNotSortedNotUnique(noOfChoices,
					noOfBlanks);
		} else if (isSorted && !isUnique) {
			numberOfOdds = getNoOfDrawsForSortedNotUnique(noOfChoices,
					noOfBlanks);
		} else if (!isSorted && isUnique) {
			numberOfOdds = getNoOfDrawsForNotSortedUnique(noOfChoices,
					noOfBlanks);
		} else if (isSorted && isUnique) {
			numberOfOdds = getNoOfDrawsForSortedUnique(noOfChoices, noOfBlanks);
		}
	}

	@Override
	public int compareTo(Rule o) {
		if (numberOfOdds.compareTo(o.numberOfOdds) == 0) {
			return name.compareTo(o.name);
		} else {
			return numberOfOdds.compareTo(o.numberOfOdds);
		}
	}

}
