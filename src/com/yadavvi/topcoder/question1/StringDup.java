package com.yadavvi.topcoder.question1;

public class StringDup {

	private int[] asciiChars;
	private char maximumChar;
	private int maxCharCount;

	public char getMax(String input) {
		maximumChar = (char) 0;
		maxCharCount = 0;
		asciiChars = new int[256];
		for (int i = 0; i < input.length(); i++) {
			asciiChars[input.charAt(i)]++;
			if (maxCharCount < asciiChars[input.charAt(i)]) {
				maxCharCount = asciiChars[input.charAt(i)];
				maximumChar = input.charAt(i);
			}
		}
		return maximumChar;
	}

}