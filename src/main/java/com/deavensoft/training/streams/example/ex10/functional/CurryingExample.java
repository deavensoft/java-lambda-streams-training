package com.deavensoft.training.streams.example.ex10.functional;

import java.util.function.BiFunction;



public class CurryingExample {
	
	public static void main (String... strings) {
		Converter converter = new Converter();
		double tenMilesInKm = converter.apply(1.609, 10.0);
		double twentyMilesInKm = converter.apply(1.609, 20.0);
		double fiftyMilesInKm = converter.apply(1.609, 50.0);
		
		System.out.println("tenMilesInKm: " + tenMilesInKm);
		System.out.println("twentyMilesInKm: " + twentyMilesInKm);
		System.out.println("fiftyMilesInKm: " + fiftyMilesInKm);
	}
	
	
	private static class Converter implements BiFunction<Double, Double, Double> {
		@Override
		public Double apply(Double conversionRate, Double value) {
			return conversionRate * value;
		}
	}	
}
