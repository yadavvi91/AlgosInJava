package com.yadavvi.sort;

public class MergeSort {

	@SuppressWarnings("rawtypes")
	private static void merge(Comparable[] a, Comparable[] aux, int lo,
			int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}

		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (j > hi)
				a[k] = aux[i++];
			else if (i > mid)
				a[k] = aux[j++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	@SuppressWarnings("rawtypes")
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo)
			return;

		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		// Merge the two sorted subarrays
		merge(a, aux, lo, mid, hi);
	}

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
}
