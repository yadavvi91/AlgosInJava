package com.yadavvi.topcoder.question23;

import static org.junit.Assert.*;

import org.junit.Test;

public class TriTravelTest {

	@Test
	public void testBestWayDown() {
		TriTravel triTravel = new TriTravel();
		assertEquals(23, triTravel.bestWayDown(new int[] { 1, 6, 7, 4, -1, 6,
				5, 8, 9, 0 }));
		assertEquals(17, triTravel.bestWayDown(new int[] { 5, 4, 1, 2, 8, -1 }));

		/*triTravel.bestWayDown(new int[] { 1, 6, 7, 4, -1, 6, 5, 8, 9, 0 });
		triTravel.bestWayDown(new int[] { 5, 4, 1, 2, 8, -1 });*/	}

}
