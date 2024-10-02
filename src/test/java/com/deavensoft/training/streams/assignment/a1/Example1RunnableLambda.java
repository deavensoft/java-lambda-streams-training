package com.deavensoft.training.streams.assignment.a1;

/**
 * Taste lambda expressions - first bite.
 * 
 * @author drazen.nikolic
 *
 */
public class Example1RunnableLambda {
	
	public static void main(String[] args) {

		// Anonymous Runnable
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello world one!");
			}
		};

		// Lambda Runnable
		// TODO 1 - Write Runnable which prints to System out: 
		//			"Hello world two!"
		// Runnable r2 = 

		
		
		// Run em!
		r1.run();
		
		// TODO 2 - Uncomment line below and run Java app, 
		//			you should get:
		//			"Hello world one!
		//			"Hello world two!
		// r2.run();
		
	}
}
