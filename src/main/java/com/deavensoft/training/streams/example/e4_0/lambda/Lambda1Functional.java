package com.deavensoft.training.streams.example.e4_0.lambda;

public class Lambda1Functional {
	public static void main(String[] args) {
//function has 4 things
//1. name - anonymous
      //2. parameter list
      //3. body
//4. return type - inferred

// can be also done automatically (in Eclipse Ctrl+1 - Quick fix -> Convert to lambda expression)

		
//		Thread th = new Thread(new Runnable() {
//			public void run() {
//				System.out.println("In another thread");
//			}
//		});
		
	    Thread th = new Thread(() -> System.out.println("In another thread")); 		
	    
	    
	    
	    th.start();

		System.out.println("In main");
	}
}
