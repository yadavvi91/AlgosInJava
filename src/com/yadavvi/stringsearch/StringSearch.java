package com.yadavvi.stringsearch;

public class StringSearch {

	public static void main(String[] args) {
		/*String text = "abacadabrabracabracadabrabrabracad";
		String pattern = "abra";*/
		/*String text = "AAAAAAAAAB";
		String pattern = "AAAAB";*/
		String text = "abacadabrabracabracadabrabrabracad";
		String pattern = "abracadabra";

		BruteForce bf = new BruteForce();
		int value;
		value = bf.search(pattern, text);

		System.out.println("The pattern is found at: " + value);

		value = bf.searchOther(pattern, text);
		System.out.println("The Other pattern is found at: " + value);

		KMP kmp = new KMP(pattern.toCharArray());
		value = kmp.search(text);
		System.out.println("The KMP pattern is found at: " + value);

		value = kmp.searchOther(text);
		System.out.println("The Other KMP pattern is found at: " + value);

		BoyerMoore bm = new BoyerMoore(pattern);
		value = bm.search(text);
		System.out.println("The Boyer Moore pattern is found at: " + value);

	}
}
