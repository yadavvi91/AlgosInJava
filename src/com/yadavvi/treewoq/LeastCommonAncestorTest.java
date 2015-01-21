package com.yadavvi.treewoq;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.yadavvi.treewoq.LeastCommonAncestor;

public class LeastCommonAncestorTest {

	/*@Test
	public void testOneItem() {
		LeastCommonAncestor lcs = new LeastCommonAncestor(Arrays.asList(1));
		assertEquals(1,
				LeastCommonAncestor.getLeastCommonAncestor(lcs.root, 1, 1));
	}

	@Test
	public void testTwoItem() {
		LeastCommonAncestor lcs = new LeastCommonAncestor(Arrays.asList(1, 2));
		assertEquals(1,
				LeastCommonAncestor.getLeastCommonAncestor(lcs.root, 1, 2));
	}

	@Test
	public void testItem1AndItem2Unique() {
		LeastCommonAncestor lcs = new LeastCommonAncestor(Arrays.asList(1, 2,
				3, 4, 5, 6, 7));
		assertEquals(4,
				LeastCommonAncestor.getLeastCommonAncestor(lcs.root, 4, 6));
	}

	@Test
	public void testItem1ParentOfItem2() {
		LeastCommonAncestor lcs = new LeastCommonAncestor(Arrays.asList(1, 2,
				3, 4, 5, 6, 7));
		assertEquals(2,
				LeastCommonAncestor.getLeastCommonAncestor(lcs.root, 2, 4));
	}

	@Test
	public void testItem1SameAsItem2() {
		LeastCommonAncestor lcs = new LeastCommonAncestor(Arrays.asList(1, 2,
				3, 4, 5, 6, 7));
		assertEquals(2,
				LeastCommonAncestor.getLeastCommonAncestor(lcs.root, 2, 2));
	}

	@Test
	public void testItem1SameAsItem2SameAsRoot() {
		LeastCommonAncestor lcs = new LeastCommonAncestor(Arrays.asList(1, 2,
				3, 4, 5, 6, 7));
		assertEquals(1,
				LeastCommonAncestor.getLeastCommonAncestor(lcs.root, 1, 1));
	}*/
	
	@Test
	public void testArray() {
		LeastCommonAncestor lcs = new LeastCommonAncestor(Arrays.asList(30, 20,
				40, 10, 25, 35, 50, 5, 15, 23, 28, 33, 38, 41, 55));
		assertEquals(30,
				LeastCommonAncestor.getLeastCommonAncestor(lcs.root, 25, 40));
		LeastCommonAncestor.prettyPrintTree(lcs.root);
	}
}
