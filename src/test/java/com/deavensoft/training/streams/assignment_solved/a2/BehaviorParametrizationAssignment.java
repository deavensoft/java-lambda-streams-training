package com.deavensoft.training.streams.assignment_solved.a2;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Employee;
import com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Position;

/**
 * The purpose of this assignment is to practice passing behavior
 * as a parameter to a method. Behavior is represented by a function (lambda expression).
 * 
 * @author drazen
 *
 */
public class BehaviorParametrizationAssignment {
	
	/**
	 * Filters input employees set by the given predicate.
	 * 
	 * [PLEASE, DO NOT CHANGE THIS METHOD]
	 * 
	 * @param employees Set of Employees
	 * @param predicate Boolean-value function (should be represented by Lambda expression).
	 * 
	 * @return Filtered set of Employees (sub-set of the input employees set).
	 */
	private Set<Employee> filterEmployees(Set<Employee> employees, Predicate<Employee> predicate) {
		return employees.stream()
				.filter(predicate)
				.collect(Collectors.toSet());
	}
	

	/**
	 * Filters input employees set and returns only employees with the given position.
	 * 
	 * @param employees Set of Employees
	 * @param position Position to filter employees by.
	 * 
	 * @return Set of Employees with a given Position (sub-set of the input employees set).
	 */
	public Set<Employee> filterEmployeesByPosition(Set<Employee> employees, Position position) {
		return filterEmployees(employees, e -> e.getPosition().equals(position));
	}
	
	/**
	 * Filters input employees set and finds employees whose age is
	 * in the given decade, like:
	 * decade 1 = 0-9 years old
	 * 2 = 10-19
	 * 3 = 20-29
	 * 4 = 30-39
	 * etc.
	 * 
	 * @param employees Set of Employees
	 * @param decadeNumber Which decade to use for filtering.
	 * 
	 * @return Set of employees with the age in the given decade.
	 */
	public Set<Employee> filterEmployeesByAgeDecade(Set<Employee> employees, int decadeNumber) {
		return filterEmployees(employees, e -> e.getAge() / 10 == decadeNumber - 1);
	}
	
	/**
	 * Filters input employees set to find only employees 
	 * whose {@link Employee#getLastname()} starts with the given letter.
	 * 
	 * Note: All lastnames starts with an upper-case letter. 
	 * Assume that letter input parameter is always given in an upper-case, too.
	 * 
	 * @param employees Set of Employees
	 * @param letter First letter of the employee's lastname, to use for filtering.
	 * 
	 * @return Set of employees whose lastname starts with the given letter.
	 */
	public Set<Employee> filterEmployeesByLastnameLetter(Set<Employee> employees, char letter) {
		return filterEmployees(employees, e -> e.getLastname().charAt(0) == letter);
	}
}
