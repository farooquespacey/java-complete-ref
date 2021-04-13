package com.farooque.gen;

interface MinMax<T extends Comparable<T>> {
	T min();

	T max();
}