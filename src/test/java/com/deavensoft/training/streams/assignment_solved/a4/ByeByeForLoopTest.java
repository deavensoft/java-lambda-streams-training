package com.deavensoft.training.streams.assignment_solved.a4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.deavensoft.training.streams.assignment_solved.modelanddata.article.Article;
import com.deavensoft.training.streams.assignment_solved.modelanddata.article.ArticleGenerator;

import static org.junit.Assert.*;

public class ByeByeForLoopTest {
	private ByeByeForLoopAssignment assignment;
	private ByeByeForLoopAssignment assignment2;
	
	@Before
	public void before() {
		assignment = new ByeByeForLoopAssignment(ArticleGenerator.getArticleList());
		assignment2 = new ByeByeForLoopAssignment(ArticleGenerator.getArticleList2());
	}
	
	@Test
	public void testGetFirstJavaArticle() {
		Article actual = assignment.getFirstJavaArticle();
		Article expected = new Article("Java 8 is so cool", "Jelani Viktor", Arrays.asList("java"));
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindArticlesByTag() {
		List<Article> actual = assignment.findArticlesByTag("java");
		List<Article> expected = new ArrayList<>();
		expected.add(new Article("Java 8 is so cool", "Jelani Viktor", Arrays.asList("java")));
		expected.add(new Article("Stream API - real power of Java", "Jamie Harvey", Arrays.asList("java", "streamapi")));

		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindArticlesByTag2() {
		List<Article> actual = assignment.findArticlesByTag("agile");
		List<Article> expected = new ArrayList<>();
		expected.add(new Article("#NoEstimate, really?", "Virginia	Fitzgerald", Arrays.asList("agile", "scrum", "noestimate")));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindArticlesByTagNoResult() {
		List<Article> actual = assignment.findArticlesByTag("somedummytag");
		List<Article> expected = new ArrayList<>();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGroupByAuthor() {
		Map<String, List<Article>> actual = assignment2.groupByAuthor();
		
		Map<String, List<Article>> expected = new HashMap<>();
		
		List<Article> articleList = new ArrayList<>();
		articleList.add(new Article("Java: The Complete Reference, Ninth Edition", "Herbert Schildt", Arrays.asList("java")));
		articleList.add(new Article("C++: The Complete Reference, 4th Edition", "Herbert Schildt", Arrays.asList("c++")));
		expected.put("Herbert Schildt", articleList);
		
		articleList = new ArrayList<>();
		articleList.add(new Article("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", Arrays.asList("design")));
		articleList.add(new Article("Agile Software Development, Principles, Patterns, and Practices", "Robert C. Martin", Arrays.asList("agile")));
		articleList.add(new Article("UML for Java Programmers", "Robert C. Martin", Arrays.asList("java", "uml", "design")));
		expected.put("Robert C. Martin", articleList);
		
		articleList = new ArrayList<>();
		articleList.add(new Article("Spring in Action", "Craig Walls", Arrays.asList("java", "spring")));
		expected.put("Craig Walls", articleList);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getDistinctTags() {
		Set<String> actual = assignment.getDistinctTags();
		Set<String> expected = new HashSet<>(Arrays.asList("nodejs", "tutorial", "java", 
				"db", "mongodb", "nosql", "agile", "scrum", "noestimate", "streamapi"));
		assertEquals(expected, actual);
	}
	
	@Test
	public void getDistinctTags2() {
		Set<String> actual = assignment2.getDistinctTags();
		Set<String> expected = new HashSet<>(Arrays.asList("c++", "design", "java", 
				"uml", "agile", "spring"));
		assertEquals(expected, actual);
	}
}
