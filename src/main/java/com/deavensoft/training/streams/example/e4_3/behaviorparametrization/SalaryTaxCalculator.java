package com.deavensoft.training.streams.example.e4_3.behaviorparametrization;

import com.deavensoft.training.streams.example.e2.imperativeprogramming.Employee;

@FunctionalInterface
public interface SalaryTaxCalculator {
	/**
	 * Calculates the salary tax, based on the brutto amount
	 * 
	 * @param brutto Salary brutto
	 * @param employee Employee to calculate tax for.
	 * 
	 * @return Tax to pay.
	 */
	Double calculate(Double brutto, Employee employee);
}
