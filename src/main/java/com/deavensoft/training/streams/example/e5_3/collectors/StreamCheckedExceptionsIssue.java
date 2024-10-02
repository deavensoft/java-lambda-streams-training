package com.deavensoft.training.streams.example.e5_3.collectors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCheckedExceptionsIssue {

	public static void main(String... args) {
		try {
			System.out.println(getClasses());
		} catch (ClassNotFoundException ignored) { }
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Class> getClasses() throws ClassNotFoundException {     
		List<Class> classes = null;
		
//	    classes =
//	        Stream.of("java.lang.Object", "java.lang.Integer", "java.lang.String")
//	              .map(className -> Class.forName(className))  // does not compile
//	              .collect(Collectors.toList());

	    return classes;
	}


}
