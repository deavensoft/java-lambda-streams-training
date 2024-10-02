package com.deavensoft.training.streams.example.e5_5.lazyevaluation;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Lazy3Logging {

	public static void main(String[] args) {
		String x = "Java 8";
		 Logger log = Logger.getLogger("hello");
		 log.setLevel(Level.INFO);
//		 log.setLevel(Level.WARNING);

		 log.info(concatenate("Hello ", x));
		 System.out.println("Finished!");
	}

	private static String concatenate (String s1, String s2) {
		System.out.println("concatenating...");
		return s1 + s2;
	}
}
