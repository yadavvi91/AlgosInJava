package com.yadavvi.tree;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeastCommonAncestorTest {

	@Test
	public void testOneItem() {
		LeastCommonAncestor lcs = new LeastCommonAncestor(Arrays.asList(1));
		assertEquals(1, (int) lcs.getLeastCommonAncestor(1, 1));
	}

	@Test
	public void testTwoItem() {
		LeastCommonAncestor lcs = new LeastCommonAncestor(Arrays.asList(1, 2));
		assertEquals(1, (int) lcs.getLeastCommonAncestor(1, 2));
	}

	@Test
	public void testItem1AndItem2Unique() {
		LeastCommonAncestor lcs = new LeastCommonAncestor(Arrays.asList(1, 2,
				3, 4, 5, 6, 7));
		assertEquals(1, (int) lcs.getLeastCommonAncestor(4, 6));
	}

	@Test
	public void testItem1ParentOfItem2() {
		LeastCommonAncestor lcs = new LeastCommonAncestor(Arrays.asList(1, 2,
				3, 4, 5, 6, 7));
		assertEquals(2, (int) lcs.getLeastCommonAncestor(2, 4));
	}

	@Test
	public void testItem1SameAsItem2() {
		LeastCommonAncestor lcs = new LeastCommonAncestor(Arrays.asList(1, 2,
				3, 4, 5, 6, 7));
		assertEquals(2, (int) lcs.getLeastCommonAncestor(2, 2));
	}

	@Test
	public void testItem1SameAsItem2SameAsRoot() {
		LeastCommonAncestor lcs = new LeastCommonAncestor(Arrays.asList(1, 2,
				3, 4, 5, 6, 7));
		assertEquals(1, (int) lcs.getLeastCommonAncestor(1, 1));
	}
}