package com.deavensoft.training.streams.example.e4_3.behaviorparametrization;

import static com.deavensoft.training.streams.example.e2.imperativeprogramming.Position.JUNIOR;
import static com.deavensoft.training.streams.example.e2.imperativeprogramming.Position.SENIOR;

import java.util.function.BiFunction;

import com.deavensoft.training.streams.example.e2.imperativeprogramming.Employee;

public class BehaviorParametrizationExample {

	public static void main(String[] args) {
		double bruttoSalary = 1000;
		Employee employee = new Employee("Sonja", "Williams", 32, SENIOR);
		Employee employee2 = new Employee("Bonnie", "Cain", 23, JUNIOR);
		
		System.out.println("Brutto salary: " + bruttoSalary);
		
		System.out.println("\nSerbian taxes:");
		BiFunction<Double, Employee, Double> serbianTaxCalculator = (brutto, e) -> brutto * 0.35d;
		System.out.println(calculateTax(bruttoSalary, employee, serbianTaxCalculator));
		System.out.println(calculateTax(bruttoSalary, employee2, serbianTaxCalculator));
		
		System.out.println("\nGerman single taxes:");
		BiFunction<Double, Employee, Double> germanSingleTaxCalculator = (brutto, e) -> brutto * (0.45d + e.getAge() * 0.003d);
		System.out.println(calculateTax(bruttoSalary, employee, germanSingleTaxCalculator));
		System.out.println(calculateTax(bruttoSalary, employee2, germanSingleTaxCalculator));
		
		System.out.println("\nGerman married taxes:");
		BiFunction<Double, Employee, Double> germanMerriedTaxCalculator = (brutto, e) -> brutto * (0.35d + e.getAge() * 0.003d 
				- (e.getPosition().equals(SENIOR) ? 0.1d : 0.0d) );
		System.out.println(calculateTax(bruttoSalary, employee, germanMerriedTaxCalculator));
		System.out.println(calculateTax(bruttoSalary, employee2, germanMerriedTaxCalculator));
	}
	
	/**
	 * Calculates salary tax based on the tax calculator.
	 * 
	 * @param brutto Salary brutto amount.
	 * @param employee Employee to calculate tax for
	 * @param taxCalculator Tax calculation logic.
	 * 
	 * @return Amount of tax to pay.
	 */
	private static double calculateTax(double brutto, Employee employee, BiFunction<Double, Employee, Double> taxCalculator) {
		return taxCalculator.apply(brutto, employee);
	}
}
