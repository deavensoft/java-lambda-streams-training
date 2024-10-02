package com.deavensoft.training.streams.example.e5_3.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample1 {

	public static void main(String[] args) {
		List<String> phrases = Arrays.asList(
		        "sporadic perjury",
		        "confounded skimming",
		        "incumbent jailer",
		        "confounded jailer");

		List<String> uniqueWords = phrases
		        .stream()
		        .flatMap(phrase -> Stream.of(phrase.split(" +")))
		        .distinct()
		        .sorted()
		        .collect(Collectors.toList());
		System.out.println("Unique words: " + uniqueWords);	
		
	}

}
