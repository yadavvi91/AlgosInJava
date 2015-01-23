package com.yadavvi.topcoder.question268;

import static org.junit.Assert.*;

import org.junit.Test;

public class LotteryTest {

	@Test
	public void testGetCombination() {
		assertEquals(45, Lottery.getCombination(10, 2));
		assertEquals(1, Lottery.getCombination(10, 10));
		assertEquals(1, Lottery.getCombination(10, 0));
		assertEquals(210, Lottery.getCombination(10, 4));
		assertEquals(210, Lottery.getCombination(10, 6));
		assertEquals(252, Lottery.getCombination(10, 5));
		assertEquals(Lottery.getCombination(11, 6),
				Lottery.getCombination(11, 5));
	}

	@Test
	public void testGetPermutation() {
		assertEquals(90, Lottery.getPermutation(10, 2));
		// assertEquals(90, Lottery.getPermutation(10, 8));
	}
}
