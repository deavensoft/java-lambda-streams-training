package com.deavensoft.training.streams.example.e5_5.lazyevaluation;

//import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Lazy1Example3 {
	public static int compute(int input) {
		System.out.println("computation executed...");
		return input * 2;
	}
	
	public static void main(String[] args) {
		int x = 2;
		
		Supplier<Integer> temp = () -> compute(x);
		//IntSupplier tempInt = () -> compute(x);
		
		if (x > 5 && temp.get() > 5) {	//tempInt.getAsInt()
			System.out.println("result");
		} else {
			System.out.println("no result");
		}
	}
}
