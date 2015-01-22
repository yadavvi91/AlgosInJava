package com.yadavvi.sort;

public class QuickSort {

	@SuppressWarnings({ "rawtypes" })
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;

		while (true) {
			while (less(a[++i], a[lo]))
				if (i == hi)
					break;
			while (less(a[lo], a[--j]))
				if (j == lo)
					break;

			if (i >= j)
				break;
			exch(a, i, j);
		}

		exch(a, lo, j);
		return j;
	}

	@SuppressWarnings("rawtypes")
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	@SuppressWarnings("rawtypes")
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;

		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
}
