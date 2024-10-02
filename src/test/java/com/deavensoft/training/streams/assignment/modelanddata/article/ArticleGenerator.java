package com.deavensoft.training.streams.assignment.modelanddata.article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticleGenerator {

	public static List<Article> getArticleList() {
		List<Article> articleList = new ArrayList<>();
		articleList.add(new Article("Node.js how-to", "Morton Hyginos", Arrays.asList("nodejs", "tutorial")));
		articleList.add(new Article("Java 8 is so cool", "Jelani Viktor", Arrays.asList("java")));
		articleList.add(new Article("MongoDB", "Kim	Singleton", Arrays.asList("db", "mongodb", "nosql")));
		articleList.add(new Article("#NoEstimate, really?", "Virginia	Fitzgerald", Arrays.asList("agile", "scrum", "noestimate")));
		articleList.add(new Article("Stream API - real power of Java", "Jamie Harvey", Arrays.asList("java", "streamapi")));
		return articleList;
	}
	
	public static List<Article> getArticleList2() {
		List<Article> articleList = new ArrayList<>();
		articleList.add(new Article("Java: The Complete Reference, Ninth Edition", "Herbert Schildt", Arrays.asList("java")));
		articleList.add(new Article("C++: The Complete Reference, 4th Edition", "Herbert Schildt", Arrays.asList("c++")));
		articleList.add(new Article("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", Arrays.asList("design")));
		articleList.add(new Article("Agile Software Development, Principles, Patterns, and Practices", "Robert C. Martin", Arrays.asList("agile")));
		articleList.add(new Article("UML for Java Programmers", "Robert C. Martin", Arrays.asList("java", "uml", "design")));
		articleList.add(new Article("Spring in Action", "Craig Walls", Arrays.asList("java", "spring")));
		return articleList;
	}
}
