package com.deavensoft.training.streams.example.e5_5.lazyevaluation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lazy2StreamExample2 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,5,4,6,7,8,9);
		
		//return the double of the first even number greater than 3
		Optional<Integer> result = numbers.stream()
				.peek(e -> System.out.println("# " + e))
				.filter(e -> e > 3)
				.peek(e -> System.out.println("|-> (f1)" + e))
				.filter(e -> e % 2 == 0)
				.peek(e -> System.out.println("  |-> (f2)" + e))
				.map(e -> e * 2)
				.peek(e -> System.out.println("      |-> (map)" + e))
				.findFirst();
				
		System.out.println(result.get());
	}
	 
}
