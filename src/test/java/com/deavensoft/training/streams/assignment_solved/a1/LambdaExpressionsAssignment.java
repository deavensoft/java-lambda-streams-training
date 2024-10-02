package com.deavensoft.training.streams.assignment_solved.a1;

import java.util.Comparator;
import java.util.Set;

import com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Employee;
import com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Position;

/**
 * The purpose of this assignment is to make simple lambda expression
 * (used for comparing two objects) and later use it in Stream API operations.
 * 
 * @author drazen
 *
 */
public class LambdaExpressionsAssignment {

	/** Employee by age comparator. 
	 *  Write Lambda expression to compare two Employee objects by age. */
	protected Comparator<Employee> employeeByAgeComparator = Comparator.comparingInt(Employee::getAge);
	
	/**
	 * Finds oldest Employee (by {@link Employee#getAge()}
	 * 
	 * @param employees Set of Employees
	 * 
	 * @return Oldest employee.
	 */
	public Employee findOldest(Set<Employee> employees) {
		return employees.stream()
				.max(employeeByAgeComparator)
				.orElse(null);
	}
	
	
	
	/**
	 * Finds oldest Employee (by {@link Employee#getAge()}
	 * within the employees of the given {@link Position} group.
	 * 
	 * Note: If there are more than one Employee having oldest age return any of those.
	 * 
	 * @param employees Set of Employees (can have different {@link Position}s).
	 * @param position Position group. 
	 * 
	 * @return Oldest employee.
	 * 
	 * @throws IllegalArgumentException If position argument is null.
	 */
	public Employee findOldestByPosition(Set<Employee> employees, Position position) 
		throws IllegalArgumentException {
		if (position == null) {
			throw new IllegalArgumentException("position is null!");
		} else {
			return employees.stream()
					.filter(e -> e.getPosition().equals(position))
					.max(employeeByAgeComparator)
					.get();
		}
	}
	
}
