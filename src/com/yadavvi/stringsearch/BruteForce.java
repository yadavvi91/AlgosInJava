package com.yadavvi.stringsearch;

public class BruteForce {

	public int search(String pattern, String text) {
		int i, N = text.length();
		int j, M = pattern.length();
		
		for (i = 0; i < N; i++) {
			for (j = 0; j < M; ) {
				if (pattern.charAt(j) == text.charAt(i + j)) j++;
				else break;
			}
			if (j == M) return i + 1;
		}
		
		return N;
	}

	public int searchOther(String pattern, String text) {
		int i, N = text.length();
		int j, M = pattern.length();
		
		for (i = 0, j = 0; i < N && j < M; i++) {
			if (pattern.charAt(j) == text.charAt(i)) {
				i++;
				j++;
			}

			if (j == M) {
				return i - j + 1;
			} else {
				i -= (j - 1);
				j = 0;
			}
		}
		return N;
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
