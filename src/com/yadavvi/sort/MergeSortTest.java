package com.yadavvi.sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortTest {

	@Test
	public void testSort() {
		Integer[] arr1 = { 12, 1, 16, 5, 4, 3, 10, 6, 8, 7 };
		Integer[] arr2 = new Integer[arr1.length];

		int i = 0;
		for (int j : arr1) {
			arr2[i++] = j;
		}
		Arrays.sort(arr2);

		MergeSort.sort(arr1);
		assertArrayEquals(arr1, arr2);
	}

}
