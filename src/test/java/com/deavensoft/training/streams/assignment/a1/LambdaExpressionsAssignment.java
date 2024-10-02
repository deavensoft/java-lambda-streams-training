package com.deavensoft.training.streams.assignment.a1;

import java.util.Comparator;
import java.util.Set;

import com.deavensoft.training.streams.assignment.modelanddata.employee.Employee;
import com.deavensoft.training.streams.assignment.modelanddata.employee.Position;

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
	protected Comparator<Employee> employeeByAgeComparator = null; // TODO - write lambda expression
	
	/**
	 * Finds oldest Employee (by {@link Employee#getAge()}
	 * 
	 * @param employees Set of Employees
	 * 
	 * @return Oldest employee.
	 */
	public Employee findOldest(Set<Employee> employees) {
		// TODO - implement
		return null;
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
		 // TODO - implement
		return null;
	}
	
}
