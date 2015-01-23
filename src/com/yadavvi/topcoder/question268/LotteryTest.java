package com.yadavvi.topcoder.question268;

import static org.junit.Assert.*;

import org.junit.Test;

public class LotteryTest {

	@Test
	public void testGetCombination() {
		assertEquals(45, LotteryUtils.getCombination(10, 2));
		assertEquals(1, LotteryUtils.getCombination(10, 10));
		assertEquals(1, LotteryUtils.getCombination(10, 0));
		assertEquals(210, LotteryUtils.getCombination(10, 4));
		assertEquals(210, LotteryUtils.getCombination(10, 6));
		assertEquals(252, LotteryUtils.getCombination(10, 5));
		assertEquals(LotteryUtils.getCombination(11, 6),
				LotteryUtils.getCombination(11, 5));
	}

	@Test
	public void testGetPermutation() {
		assertEquals(90, LotteryUtils.getPermutation(10, 2));
		// assertEquals(90, LotteryUtils.getPermutation(10, 8));
	}

	@Test
	public void testSortByOdds() {
		Lottery lottery = new Lottery();
		String[] lotteryTest;
		String[] lotterySolution = { "PICK TWO LIMITED", "PICK TWO IN ORDER",
				"PICK TWO DIFFERENT", "PICK ANY TWO" };
		String[] lotterySolution2 = { "RED", "ORANGE", "YELLOW", "GREEN",
				"BLUE", "INDIGO", "VIOLET" };
		String[] lotterySolution3 = {};

		lotteryTest = lottery.sortByOdds(new String[] {
				"PICK ANY TWO: 10 2 F F", "PICK TWO IN ORDER: 10 2 T F",
				"PICK TWO DIFFERENT: 10 2 F T", "PICK TWO LIMITED: 10 2 T T" });
		assertEquals(lotteryTest.length, lotterySolution.length);
		for (int i = 0; i < lotteryTest.length; i++) {
			assertEquals(lotteryTest[i], lotterySolution[i]);
		}

		/*lotteryTest = lottery.sortByOdds(new String[] { "INDIGO: 93 8 T F",
				"ORANGE: 29 8 F T", "VIOLET: 76 6 F F", "BLUE: 100 8 T T",
				"RED: 99 8 T T", "GREEN: 78 6 F T", "YELLOW: 75 6 F F" });
		assertEquals(lotteryTest.length, lotterySolution2.length);
		for (int i = 0; i < lotteryTest.length; i++) {
			assertEquals(lotteryTest[i], lotterySolution2[i]);
		}*/

		lotteryTest = lottery.sortByOdds(new String[] {});
		assertEquals(lotteryTest.length, lotterySolution3.length);
		for (int i = 0; i < lotteryTest.length; i++) {
			assertEquals(lotteryTest[i], lotterySolution3[i]);
		}

	}
}
