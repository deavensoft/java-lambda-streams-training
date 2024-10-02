package com.deavensoft.training.streams.example.ex10.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * At its core, currying is a functional programming technique that involves breaking down a function
 * that takes multiple arguments into a series of functions that take one argument each.
 * This creates a chain of functions, where each function returns another function
 * until the final result is achieved.
 */
public class CurryingExample2 {
	
	public static void main (String... strings) {
		Converter converter = new Converter();
		
		// mi2km
		Function<Double, Double> mi2kmConverter = converter.curry(1.609);
		double tenMilesInKm = mi2kmConverter.apply(10.0);
		double twentyMilesInKm = mi2kmConverter.apply(20.0);
		double fiftyMilesInKm = mi2kmConverter.apply(50.0);
		
		System.out.println("tenMilesInKm: " + tenMilesInKm);
		System.out.println("twentyMilesInKm: " + twentyMilesInKm);
		System.out.println("fiftyMilesInKm: " + fiftyMilesInKm);
		
		
		// on2gr
		Function<Double, Double> ou2grConverter = converter.curry(28.345);
		double tenOuncesInGr = ou2grConverter.apply(10.0);
		double twentyOuncesInGr = ou2grConverter.apply(20.0);
		double fiftyOuncesInGr = ou2grConverter.apply(50.0);

		System.out.println("tenOuncesInGr: " + tenOuncesInGr);
		System.out.println("twentyOuncesInGr: " + twentyOuncesInGr);
		System.out.println("fiftyOuncesInGr: " + fiftyOuncesInGr);

	}

	static class Converter implements ExtendedBiFunction<Double, Double, Double> {
		public Double apply(Double conversionRate, Double value) {
			return conversionRate * value;
		}
	}
	
	@FunctionalInterface
	public interface ExtendedBiFunction<T, U, R>  extends BiFunction<T, U, R> {
	    default Function<U, R> curry(T t) {
	        return u -> apply(t, u);
	    }
	}
}
