package com.yadavvi.stacktest;

public interface Stack<T> {
	void push(T object);

	T pop();

	int size();

	void clear();

	boolean isEmpty();
}