package com.yadavvi.stringsearch;


public class BruteForce {

	public int search(String pattern, String text) {
		int i, N = text.length();
		int j, M = pattern.length();
		
		for (i = 0; i < N; i++) { // implicit backup
			for (j = 0; j < M; ) {
				if (pattern.charAt(j) == text.charAt(i + j)) j++;
				else break;
			}
			if (j == M) return i;
		}
		
		return N;
	}

	public int searchOther(String pattern, String text) {
		int i, N = text.length();
		int j, M = pattern.length();
		
		for (i = 0, j = 0; i < N && j < M; i++) {
			if (text.charAt(i) == pattern.charAt(j)) j++;
			else { i -= j; j = 0; } // explicit backup
		}
		
		if (j == M) return i - j;
		else 		return N;
	}
}