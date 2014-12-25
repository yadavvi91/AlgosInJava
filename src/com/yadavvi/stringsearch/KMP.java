package com.yadavvi.stringsearch;

import java.util.Arrays;

public class KMP {
	
	char[] pattern;
	/**
	 * DFA keeps track of the state changes when a new character is encountered.
	 * <p>
	 * It is defined as --> <tt>int[][] dfa = new int[R][M];</tt> where <i>R</i>
	 * is the character set (usually 256 chars 0 to 255 for UTF-8) and <i>M</i>
	 * is the size of pattern.
	 * <p>
	 * What this means is, if you are in state  <b><i>m</i></b>  and you encounter a
	 * character  <b><i>r</i></b>,  what would be your next state? The next state is
	 * stored in - dfa[<b><i>m</i></b>][<b><i>r</i></b>].
	 */
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

	public int searchOther(String text) {
		int i, N = text.length();
		int j, M = pattern.length;

		for (i = 0, j = 0; i < N && j < M; i++)
			j = dfa[text.charAt(i)][j];
		
		if (j == M) return i - M;
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