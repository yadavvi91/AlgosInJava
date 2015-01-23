package com.yadavvi.topcoder.question1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringDupTest {

	@Test
	public void testGetMax() {
		StringDup strDup = new StringDup();
		assertEquals('c', strDup.getMax("aaiicccnn"));
		assertEquals('a', strDup.getMax("aabbccdd"));
		assertEquals('2', strDup.getMax("ab2sbf2dj2skl"));
	}
}
