package com.yadavvi.topcoder.question268;

import java.util.Iterator;

import javax.naming.directory.InvalidAttributesException;

public class Rule implements Comparable<Rule>, Iterable<Rule> {

	String name;
	String[] conditions;
	int noOfChoices;
	int noOfBlanks;
	boolean isSorted;
	boolean isUnique;
	long numberOfOdds;

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

	private void calculateOdds() {
		if (!isSorted && !isUnique) {
			numberOfOdds = LotteryUtils.getNoOfDrawsForNotSortedNotUnique(
					noOfChoices, noOfBlanks);
		} else if (isSorted && !isUnique) {
			numberOfOdds = LotteryUtils.getNoOfDrawsForSortedNotUnique(
					noOfChoices, noOfBlanks);
		} else if (!isSorted && isUnique) {
			numberOfOdds = LotteryUtils.getNoOfDrawsForNotSortedUnique(
					noOfChoices, noOfBlanks);
		} else if (isSorted && isUnique) {
			numberOfOdds = LotteryUtils.getNoOfDrawsForSortedUnique(
					noOfChoices, noOfBlanks);
		}
	}

	@Override
	public int compareTo(Rule o) {
		if (numberOfOdds < o.numberOfOdds)
			return -1;
		else if (numberOfOdds > o.numberOfOdds)
			return 1;
		else
			return 0;
	}

	@Override
	public Iterator<Rule> iterator() {
		return new RuleIterator();
	}

	private class RuleIterator implements Iterator<Rule> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Rule next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}
}
