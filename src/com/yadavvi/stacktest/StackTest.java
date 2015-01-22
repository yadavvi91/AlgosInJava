package com.yadavvi.stacktest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackTest {

	private StackImpl<Integer> stack;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	public StackTest() {
		stack = new StackImpl<>();
	}

	// Testing exceptions using exception = ExceptionName.class
	@Test(expected = NoSuchElementException.class)
	public void popEmptyStack() {
		stack.clear();
		stack.pop();
	}

	@Test(expected = IllegalArgumentException.class)
	public void pushNull() {
		stack.push(null);
	}

	@Test
	public void isEmptyStackSizeZero() {
		if (stack.isEmpty()) {
			assertEquals(0, stack.size());
		} else {
			assertNotEquals(0, stack.size());
		}
	}

	@Test
	public void isSizeOfOnePushOne() {
		stack.clear();
		stack.push(5);
		assertEquals(1, stack.size());
	}

	@Test
	public void sameObjectsInReverseOrder() {
		stack.clear();
		stack.push(5);
		stack.push(3);
		assertEquals(new Integer(3), stack.pop());
		assertEquals(new Integer(5), stack.pop());

		// Defining a @Rule for an exception and then testing
		// it using exception.expect(ExceptionName.class).
		exception.expect(NoSuchElementException.class);
		// Can also test for a specific message in the exception
		// exception.expectMessage("Stack is null");
		stack.pop();
	}

	@Test
	public void testIterator() {

		int i = 0;
		int[] arr = { 5, 3, 12, 21, 16, 1 };

		stack.clear();

		for (i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}

		i = arr.length;
		for (Iterator<Integer> iterator = stack.iterator(); iterator.hasNext()
				&& i > 0; i--) {
			assertEquals(new Integer(arr[i - 1]), iterator.next());
		}
	}

}
