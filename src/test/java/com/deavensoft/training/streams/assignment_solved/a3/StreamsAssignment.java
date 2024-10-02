package com.deavensoft.training.streams.assignment_solved.a3;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Employee;
import com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Position;

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
//		return numbers.stream()
//				.filter(x -> x % 2 == 0)
//				.mapToInt(Integer::valueOf)
//				.sum();
		
		return numbers.stream()
				.filter(x -> x % 2 == 0)
//				.reduce(0, (s, n) -> s + n);
				.reduce(0, Integer::sum);
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
		return employees.stream()
				.collect(Collectors.groupingBy(Employee::getPosition, 
						Collectors.toSet()));
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
		return employees.stream()
				.filter(predicate)
				.collect(Collectors.toSet());
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
		return employees.stream()
				.collect(Collectors.partitioningBy(e -> e.getPosition().equals(Position.SENIOR),
						 Collectors.toSet()));
	}
}
