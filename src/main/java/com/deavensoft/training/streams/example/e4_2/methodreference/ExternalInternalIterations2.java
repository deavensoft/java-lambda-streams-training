package com.deavensoft.training.streams.example.e4_2.methodreference;

import java.util.Arrays;
import java.util.List;

public class ExternalInternalIterations2 {

	public static void main(String[] args) {
		   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		    
		    //external iterators
		    // for(int i = 0; i < numbers.size(); i++) {
		    //   System.out.println(numbers.get(i));
		    // }
		    
		    //external iterators also
		    // for(int e : numbers) {
		    //   System.out.println(e);
		    // }
		    
		    //internal iterators
		    // numbers.forEach(new Consumer<Integer>() {
		    //   public void accept(Integer value) {
		    //     System.out.println(value);
		    //   }
		    // });


		    // numbers.forEach((Integer value) -> System.out.println(value));

		    //numbers.forEach((value) -> System.out.println(value));
		    //Java 8 has type inference, finally, hold your tweets, but only for
		    //lambda expressions.
		 
		    //numbers.forEach(value -> System.out.println(value));
		    //parenthesis is optional, but only for one parameter lambdas.
		    
		    numbers.forEach(System.out::println); 	}

}
