package com.deavensoft.training.streams.assignment_solved.a6;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Employee;

/**
 * This assignment is used to practice new Java 8 Optional<T> usage.
 * 
 * @author drazen
 *
 */
public class OptionalAssignment {

	/** Message to return when employee could not be found (see method descriptions below). */
	public static final String NOT_FOUND_MESSAGE = "Not found!";
	
	/**
	 * Finds any Employee from the input employeeSet
	 * which matches the given Predicate.
	 * If there is no match, empty option should be returned.
	 * 
	 * @param employeeSet Set of employees.
	 * @param predicate Predicate (a boolean) function to filter Employees with.
	 * 
	 * @return Single Employee (wrapped in Optional) or empty Optional (if nothing is found).
	 */
	public Optional<Employee> findEmployee(Set<Employee> employeeSet, Predicate<Employee> predicate) {
		return employeeSet.stream()
				.filter(predicate)
				.findAny();
	}
	
	
	/**
	 * Finds any Employee which satisfies predicate (boolean) function 
	 * and returns its Lastname (or {@link this#NOT_FOUND_MESSAGE}).
	 * 
	 * @param employeeSet
	 * @param predicate
	 * 
	 * @return Found (single) employee Lastname or {@link this#NOT_FOUND_MESSAGE}.
	 */
	public String findEmployeeName(Set<Employee> employeeSet, Predicate<Employee> predicate) {
		Optional<Employee> employee = findEmployee(employeeSet, predicate);
		return employee.map(Employee::getLastname)
				.orElse(NOT_FOUND_MESSAGE);
		
	}
}
