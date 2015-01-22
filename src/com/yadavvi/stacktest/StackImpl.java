package com.yadavvi.stacktest;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl<T> implements Stack<T>, Iterable<T> {

	private int size;
	private Node<T> first;

	private static class Node<T> {
		private T item;
		private Node<T> prev;
	}

	public StackImpl() {
		size = 0;
		first = null;
	}

	/**
	 * Empty the Stack.
	 */
	@Override
	public void clear() {
		first = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	@Override
	public void push(T object) {
		if (object == null) {
			throw (new IllegalArgumentException(
					"Pushed object shouldn't be null"));
		}
		Node<T> oldItem = first;
		first = new Node<>();
		first.item = object;
		first.prev = oldItem;
		size++;
	}

	@Override
	public T pop() {
		if (first == null) {
			throw (new NoSuchElementException("Stack is null"));
		}
		Node<T> firstNode = first;
		first = first.prev;
		size--;
		return firstNode.item;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>(first);
	}

	@SuppressWarnings("hiding")
	private class ListIterator<T> implements Iterator<T> {

		private Node<T> current;

		public ListIterator(Node<T> first) {
			current = first;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T item = current.item;
			current = current.prev;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}
}
