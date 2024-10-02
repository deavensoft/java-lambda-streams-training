package com.deavensoft.training.streams.example.e5_0.streamintro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class StreamExample4AvoidSharedMutability {

	public static void main(String[] args) {
	    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

	    //double the even values and put that into a list.
	    
	    //wrong way to do this.
	    List<Integer> doubleOfEven = new ArrayList<>();

	    numbers.stream()
	           .filter(e -> e % 2 == 0)
	           .map(e -> e * 2)
	           .forEach(e -> doubleOfEven.add(e));
	    //mutability is OK, sharing is nice, shared mutability is devils work
	    
	    //friends don't let friends do shared mutation.
	    
	    System.out.println(doubleOfEven); //Don't do this.
	    
	    List<Integer> doubleOfEven2 = numbers.stream()
	             .filter(e -> e % 2 == 0)
	             .map(e -> e * 2)
	             .collect(toList());
	    System.out.println(doubleOfEven2);
	    
	    
	    
	    // toSet
	    Set<Integer> doubleOfEven2Set =
  	      numbers.stream()
  	             .filter(e -> e % 2 == 0)
  	             .map(e -> e * 2)
  	             .collect(toSet());
  	    System.out.println(doubleOfEven2Set);

      	    
	}	

}
