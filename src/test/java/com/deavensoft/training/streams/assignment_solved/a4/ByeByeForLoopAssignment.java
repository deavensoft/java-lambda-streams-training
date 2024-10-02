package com.deavensoft.training.streams.assignment_solved.a4;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.deavensoft.training.streams.assignment_solved.modelanddata.article.Article;

/**
 * In this assignment your task is to refactor legacy code.
 * Refactor each for-loop logic using Streams API.
 * At the end you should have no for-loop in this class.
 * 
 * @author drazen
 *
 */
public class ByeByeForLoopAssignment {

	private final static String JAVA_TAG = "java";
	private final List<Article> articles;
	
	/**
	 * Constuctor - creates new instance with the given 
	 * list of articles to work with.
	 * 
	 * [PLEASE, DO NOT CHANGE THIS METHOD]
	 * 
	 * @param articles List of articles.
	 */
	public ByeByeForLoopAssignment(List<Article> articles) {
		this.articles = articles;
	}
	
	
	
	/**
	 * Finds first article in the list of articles
	 * which contains tag "java", as specificed by constant {@link this#JAVA_TAG}.
	 * 
	 * @return First Java Article
	 */
	public Article getFirstJavaArticle() {

//	    for (Article article : articles) {
//	        if (article.getTags().contains(JAVA_TAG)) {
//	            return article;
//	        }
//	    }
//
//	    return null;
		
		//----------------------
		return articles.stream()
		        .filter(article -> article.getTags().contains(JAVA_TAG))
		        .findFirst()
				.orElse(null);
		//----------------------
	}
	
	/**
	 * Finds all articles having the specified tag.
	 * 
	 * @param tag Name of the tag.
	 * 
	 * @return List of Articles. If there is no results found, empty List is returned.
	 */
	public List<Article> findArticlesByTag(String tag) {

//	    List<Article> result = new ArrayList<>();
//
//	    for (Article article : articles) {
//	        if (article.getTags().contains(tag)) {
//	            result.add(article);
//	        }
//	    }
//
//	    return result;
		
		//----------------------
		return articles.stream()
		        .filter(article -> article.getTags().contains(tag))
		        .collect(Collectors.toList());
		//----------------------
	}	
	
	/**
	 * Groups articles by author.
	 * 
	 * @return Map where key = Author, value List of Articles for this Author
	 */
	public Map<String, List<Article>> groupByAuthor() {

//	    Map<String, List<Article>> result = new HashMap<>();
//
//	    for (Article article : articles) {
//	        if (result.containsKey(article.getAuthor())) {
//	            result.get(article.getAuthor()).add(article);
//	        } else {
//	            ArrayList<Article> articles = new ArrayList<>();
//	            articles.add(article);
//	            result.put(article.getAuthor(), articles);
//	        }
//	    }
//
//	    return result;
		
		//----------------------
		return articles.stream()
		        .collect(Collectors.groupingBy(Article::getAuthor));
		//----------------------
	}	
	
	/**
	 * Get all tags which are used by the article
	 * 
	 * HINT: When converting to Stream API version, use flatMap()
	 * 
	 * @return Set of tag names.
	 */
	public Set<String> getDistinctTags() {

//	    Set<String> result = new HashSet<>();
//
//	    for (Article article : articles) {
//	        result.addAll(article.getTags());
//	    }
//
//	    return result;
		//----------------------
		return articles.stream()
		        .flatMap(article -> article.getTags().stream())
		        .collect(Collectors.toSet());
		//----------------------
	}	
}
