package com.yadavvi.stringsearch;

import java.util.Arrays;

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
		/*String text = "abacadabrabracabracadabrabrabracad";
		String pattern = "abra";*/
		/*String text = "AAAAAAAAAB";
		String pattern = "AAAAB";*/
		String text = "abacadabrabracabracadabrabrabracad";
		String pattern = "abracadabra";

		BruteForce bf = new BruteForce();
		int value;
		value= bf.search(pattern, text);

		System.out.println("The pattern is found at: " + value);
		
		value = bf.searchOther(pattern, text);
		System.out.println("The Other pattern is found at: " + value);
		
		KMP kmp = new KMP(pattern.toCharArray());
		value = kmp.search(text);
		System.out.println("The KMP pattern is found at: " + value);
	}
}

class KMP {
	
	char[] pattern;
	int[][] dfa;
	char[] distinctChars;
	
	public KMP(char[] pat) {
		int M = pat.length;
		pattern = new char[M];
		for (int i = 0; i < M; i++)
			pattern[i] = pat[i];

		getDistinctChars();

		// M and R give the "length of pattern" and "no. of chars" respectively.
		// Here, M's value is already defined above.
		int R = 256;
		dfa = new int[R][M];

		// Populate all the elements that lead to next state.
		for (int i = 0; i < M; i++)
			dfa[pattern[i]][i] = i + 1;

		for (int i = 0; i < R; i++) {
			if (pattern[0] != i)
				dfa[i][0] = 0;
		}

		int X = 0;
		int i, j;
		for (i = 1; i < M; i++) {
			for (j = 0; j < R; j++) {
				if (pattern[i] != j)
					dfa[j][i] = dfa[j][X];
			}
			X = dfa[pattern[i]][X];
		}

		printDFA();
	}
	
	public int search(String text) {
		int i, N = text.length();
		int j, M = pattern.length;
		
		for (i = 0, j = 0; i < N && j < M; i++) {
			if (j < M && dfa[text.charAt(i)][j] == j + 1) j++;
			else if (j == M) break; 
			else j = 0;
		}
		if (j == M) return i - j;
		return N;
	}
	
	private void getDistinctChars() {
		int i, j;
		int M = pattern.length;

		char[] sortedPattern = new char[M];
		for (i = 0; i < M; i++)
			sortedPattern[i] = pattern[i];
		Arrays.sort(sortedPattern);

		int count = 1;
		for (i = 1; i < M; i++) {
			while (i < M && sortedPattern[i] == sortedPattern[i - 1])
				i++;
			count++;
		}

		distinctChars = new char[count];
		distinctChars[0] = sortedPattern[0];
		for (i = 0, j = 0; i < M; i++) {
			if (distinctChars[j] != sortedPattern[i]) {
				j++;
				distinctChars[j] = sortedPattern[i];
			}
		}
	}

	public void printDFA() {
		int i, j;
		int M = pattern.length;
		int count = distinctChars.length;

		System.out.printf("     ");
		for (i = 0; i < M; i++)
			System.out.printf("%5c", pattern[i]);
		System.out.println();

		for (i = 0; i < count; i++) {
			System.out.printf("%5c", distinctChars[i]);
			for (j = 0; j < M; j++)
				System.out.printf("%5d", dfa[distinctChars[i]][j]);
			System.out.println();
		}
	}
}