package com.yadavvi.stringsearch;

public class BoyerMoore {

	char[] pattern;
	int[] right;

	public BoyerMoore(String pat) {
		int M = pat.length();

		pattern = new char[M];
		for (int i = 0; i < M; i++)
			pattern[i] = pat.charAt(i);

		int R = 256; // character set.
		right = new int[256];

		for (int i = 0; i < R; i++)
			right[i] = -1;

		for (int i = 0; i < M; i++)
			right[pattern[i]] = i;
	}
	
	public int search(String text) {
		int N = text.length();
		int M = pattern.length;
		
		int skip = 0;
		for (int i = 0; i < N - M; i += skip) {
			skip = 0;
			for (int j = 0; j < M; j++)
				if (text.charAt(i + j) != pattern[j]) {
					skip = Math.max(1, j - right[j]);
					break;
				}
			if (skip == 0) return i;
		}
		return N;
	}
}
