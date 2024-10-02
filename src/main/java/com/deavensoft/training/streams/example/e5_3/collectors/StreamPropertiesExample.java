package com.deavensoft.training.streams.example.e5_3.collectors;

import java.util.Arrays;
import java.util.List;

public class StreamPropertiesExample {

	public static void main(String[] args) {
	    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
	    
	    numbers.stream()
	           .filter(e -> e % 2 == 0)
	           .forEach(System.out::println);
	    //sized, ordered, non-distinct, non-sorted 	
	    
	    
//	    numbers.stream()
//	        .filter(e -> e % 2 == 0)
//	        .sorted()
//	        .forEach(System.out::println);
	    //sized, ordered, non-distinct, sorted 	  
	    
	    
//	    numbers.stream()
//	        .filter(e -> e % 2 == 0)
//	        .distinct()
//	        .forEach(System.out::println);
 //sized, ordered, distinct, non-sorted 	    
	}

}
