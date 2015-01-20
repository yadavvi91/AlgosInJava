package com.yadavvi.prettyprint;

import java.util.Arrays;

import org.junit.Test;

public class PrettyPrintTreeTest {

	@Test
	public void testPrettyPrint() {
		PrettyPrintTree lcs = new PrettyPrintTree(Arrays.asList(30, 20,
				40, 10, 25, 35, 50, 5, 15, 23, 28, 33, 38, 41, 55));
		PrettyPrintTree.prettyPrintTree(lcs.root);
	}

}
