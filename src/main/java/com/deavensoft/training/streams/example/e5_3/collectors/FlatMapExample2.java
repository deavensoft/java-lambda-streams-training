package com.deavensoft.training.streams.example.e5_3.collectors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample2 {

	public static void main(String[] args) {
		 List<Developer> team = new ArrayList<>();
	        Developer polyglot = new Developer("esoteric");
	        polyglot.add("clojure");
	        polyglot.add("scala");
	        polyglot.add("groovy");
	        polyglot.add("go");

	        Developer busy = new Developer("pragmatic");
	        busy.add("java");
	        busy.add("javascript");

	        team.add(polyglot);
	        team.add(busy);

	        List<String> teamLanguages = team.stream().
	                map(d -> d.getLanguages()).
	                flatMap(l -> l.stream()).
	                collect(Collectors.toList());
	        
		System.out.println("teamLanguages: " + teamLanguages);	
		
	}

	private static class Developer {

		@SuppressWarnings("unused")
		private String name;
		private Set<String> languages;

		public Developer(String name) {
			this.languages = new HashSet<>();
			this.name = name;
		}

		public void add(String language) {
			this.languages.add(language);
		}

		public Set<String> getLanguages() {
			return languages;
		}
	}
	
}


