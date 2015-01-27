package com.yadavvi.topcoder.question23;

public class TriTravel {

	public int bestWayDown(int[] triValues) {
		int height = (int) heightOfTriangle(triValues.length);
		int noOfElementsLeft = triValues.length;
		int presentLevel = height;
		int startVal = noOfElementsLeft - presentLevel;
		int endVal = noOfElementsLeft;

		int[] prevLevel = new int[height];
		for (int i = 0; i < height; i++)
			prevLevel[i] = triValues[startVal + i];

		noOfElementsLeft -= presentLevel;
		presentLevel--;
		startVal = noOfElementsLeft - presentLevel;
		endVal = noOfElementsLeft;

		while (noOfElementsLeft > 0) {
			for (int i = 0; i < endVal - startVal; i++) {
				prevLevel[i] = triValues[startVal + i]
						+ (prevLevel[i] > prevLevel[i + 1] ? prevLevel[i]
								: prevLevel[i + 1]);
			}
			noOfElementsLeft -= presentLevel;
			presentLevel--;
			startVal = noOfElementsLeft - presentLevel;
			endVal = noOfElementsLeft;
		}

		System.out.println("Best Way Down: " + prevLevel[0]);
		return prevLevel[0];
	}

	private double heightOfTriangle(int length) {
		double discriminant = Math.sqrt(1 - (4 * -2 * length));
		discriminant = discriminant < 0 ? -discriminant : discriminant;

		return (-1 + discriminant) / 2;
	}

}
