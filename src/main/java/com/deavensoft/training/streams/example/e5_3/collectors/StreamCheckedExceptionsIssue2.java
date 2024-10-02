package com.deavensoft.training.streams.example.e5_3.collectors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCheckedExceptionsIssue2 {

	public static void main(String... args) {
		try {
			System.out.println(getClasses());
		} catch (ClassNotFoundException ignored) { }
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Class> getClasses() throws ClassNotFoundException {     

	    List<Class> classes = 
	        Stream.of("java.lang.Object", "java.lang.Integer", "java.lang.String")
	              .map(className -> { 
						try {
							return Class.forName(className);
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
	              })
	              .collect(Collectors.toList());

	    return classes;
	}


}
