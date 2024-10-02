package com.deavensoft.training.streams.example.e5_3.collectors;

import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class InfinitiveStreamExample {

	public static void main(String[] args) {
		Stream<Integer> evenNumbers = Stream.iterate(0, n -> n + 2);

		System.out.println(evenNumbers
				.limit(10)
				.collect(toList()));
		
		
//		Stream<Double> randomNumbers = Stream.generate(Math::random);
//		System.out.println(randomNumbers			
//				.map(e -> Double.valueOf(e * 100).intValue())
//				.limit(10)
//				.sorted()
//				.collect(toList()));
	}

}
