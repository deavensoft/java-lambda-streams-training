package com.deavensoft.training.streams.example.e5_4.parallelstream;

import java.util.Arrays;
import java.util.List;

public class StreamExample3Parallel {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Timeit.code(() -> System.out.println(
				 numbers.stream() // TODO: parallel stream
					.filter(e -> e % 2 == 0)
					.mapToInt(StreamExample3Parallel::compute)
					.sum()));
	}

	public static int compute(int number) {
		// assume this is time intensive
		try {Thread.sleep(1000);} catch (Exception ignored) {}
		return number * 2;
	}
}
