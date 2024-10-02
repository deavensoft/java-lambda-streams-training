package com.deavensoft.training.streams.example.e5_5.lazyevaluation;

public class Lazy1Example2 {
	public static int compute(int input) {
		System.out.println("computation executed...");
		return input * 2;
	}
	
	public static void main(String[] args) {
		int x = 2;
		
		int temp = compute(x);
		if (x > 5 && temp > 5) {	
			System.out.println("result");
		} else {
			System.out.println("no result");
		}
	}
}
