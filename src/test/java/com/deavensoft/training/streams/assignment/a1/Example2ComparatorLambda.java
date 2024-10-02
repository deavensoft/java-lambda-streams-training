package com.deavensoft.training.streams.assignment.a1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.deavensoft.training.streams.assignment.modelanddata.employee.Employee;
import com.deavensoft.training.streams.assignment.modelanddata.employee.EmployeeGenerator;

/**
 * Writing Comparator using Lambda expression
 * 
 * @author drazen.nikolic
 *
 */
public class Example2ComparatorLambda {
	
	public static void main(String[] args) {
		Set<Employee> employees = EmployeeGenerator.employeeSet1();
		
		List<Employee> employeesList = new ArrayList<>(employees);
		// TODO 1 - implement anonymous function which compares	employees 
		//			by first name, in a line below (uncomment it first).
		//Collections.sort(employeesList, <anonymous function>);
		
		System.out.println("Sorted by first name:");
		EmployeeGenerator.print(employeesList);
		
		
		List<Employee> employeesListLambda = new ArrayList<>(employees);
		// TODO 2 - implement comparator using lambda expression which compares employees
		//			by age, in a line below (uncomment it first)
		//Collections.sort(employeesListLambda, <lambda expression>);
		
		System.out.println("\n\nSorted by age:");
		EmployeeGenerator.print(employeesListLambda);
		
	}
}
