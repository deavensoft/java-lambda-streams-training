package com.deavensoft.training.streams.example.e4_1.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalInterfaceExample {

	public static void main(String[] args) {
		Converter<Double, Double> usd2eurConverter = x -> x * .9;
		
		System.out.println(usd2eurConverter.convert(100.0d));
		
		
		
		Converter<String, String> uppercaseConverter = s -> s.toUpperCase();
		
		System.out.println(uppercaseConverter.convert("Java"));
		System.out.println(uppercaseConverter.convert("this were all small letters"));
		
		
		
		Converter<String, List<Integer>> commaDelimitedStringConverter =
				s -> Arrays.asList(s.split(",")).stream()
						.map(x -> Integer.valueOf(x))
						.collect(Collectors.toList());
				
		System.out.println(commaDelimitedStringConverter.convert("1,2,3,4,5"));	
		
		
		Converter<Frog, Prince> kissConverter = frog -> new Prince(frog);
		
		Frog frog = new Frog();
		System.out.println(frog + "... kiss... buuum.... " + kissConverter.convert(frog));
	}

}
