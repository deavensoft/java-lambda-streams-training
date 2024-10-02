package com.deavensoft.training.streams.assignment.a3;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import com.deavensoft.training.streams.assignment.modelanddata.employee.Employee;
import com.deavensoft.training.streams.assignment.modelanddata.employee.Position;

/**
 * The purpose of this assignment is to try different methods
 * in Stream API.
 * 
 * @author drazen
 *
 */
public class StreamsAssignment {
	
	/**
	 * Sum all even numbers.
	 * 
	 * @param numbers Numbers to use.
	 * 
	 * @return Result (sum of all even numbers).
	 */
	public Integer sumAllEvenNumbers(Set<Integer> numbers) {
		// TODO - implement
		return null;
		
	}
	/**
	 * Groups employees by {@link Position}. 
	 * 
	 * @param employees Set of Employees.
	 * 
	 * @return Map where 
	 * 			key is Position and 
	 * 			value is a Set<Employee> having the given position (ordered by {@link Employee#getFirstname()}).
	 */
	public Map<Position, Set<Employee>> groupEmployeesByPositions(Set<Employee> employees) {
		// TODO - implement
		return null;
	}
	
	/**
	 * Find employees by the given Predicate.
	 * {@link Predicate} is a function which returns boolean value.
	 * 
	 * @param employees Set of Employees.
	 * @param predicate Predicate function to be used for finding employees.
	 * 
	 * @return Set of Employees matching the given Predicate.
	 */
	public Set<Employee> findEmployees(Set<Employee> employees, Predicate<Employee> predicate) {
		// TODO - implement
		return null;
	}

	/**
	 * Partition Employees by Seniors and the others. 
	 * 
	 * 
	 * @param employees Set of employees 
	 * 
	 * @return Map, key=false non-seniors; key=true seniors.
	 */
	public Map<Boolean, Set<Employee>> partitionSeniors(Set<Employee> employees) {
		// TODO - implement
		return null;
	}
}
