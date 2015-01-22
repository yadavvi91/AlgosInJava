package com.yadavvi.projecteuler.question6;

import static org.junit.Assert.*;

import org.junit.Test;

public class DifferenceFinderTest {
    
	@Test
	public void testComputeDifference() {
		long startTime, endTime;
		startTime = System.nanoTime();
		assertEquals(25164150, DifferenceFinder.computeDifference());
		endTime = System.nanoTime();
		System.out.println("Time used: " + (endTime - startTime));
	}

	@Test
	public void testComputeDifferenceFormula() {
		long startTime, endTime;
		startTime = System.nanoTime();
		assertEquals(25164150, DifferenceFinder.computeDifferenceFormula(100));
		endTime = System.nanoTime();
		System.out.println("Time used: " + (endTime - startTime));
	}

}