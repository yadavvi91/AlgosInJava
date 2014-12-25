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

	public static void main(String[] args) {
		String text = "abacadabrabracabracadabrabrabracad";
		String pattern = "abra";

		BruteForce bf = new BruteForce();
		int value;
		value= bf.search(pattern, text);

		System.out.println("The pattern is found at: " + value);
		
		value = bf.searchOther(pattern, text);
		System.out.println("The Other pattern is found at: " + value);
	}
}
