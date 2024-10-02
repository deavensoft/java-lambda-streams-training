package com.deavensoft.training.streams.example.e5_0.streamintro;

import java.util.Arrays;
import java.util.List;

public class StreamExample1 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// given the values, double the even numbers and total.

		int result = 0;

		for (int e : numbers) {
			if (e % 2 == 0) {
				result += e * 2;
			}
		}

		System.out.println(result);
	}
}
