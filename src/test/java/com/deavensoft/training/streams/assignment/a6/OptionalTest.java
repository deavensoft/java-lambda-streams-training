package com.deavensoft.training.streams.assignment.a6;

import static com.deavensoft.training.streams.assignment.modelanddata.employee.Position.JUNIOR;
import static com.deavensoft.training.streams.assignment.modelanddata.employee.Position.REGULAR;
import static com.deavensoft.training.streams.assignment.modelanddata.employee.Position.SENIOR;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.deavensoft.training.streams.assignment.modelanddata.employee.Employee;
import com.deavensoft.training.streams.assignment.modelanddata.employee.EmployeeGenerator;


public class OptionalTest {
	
	private OptionalAssignment assignment;
	private Set<Employee> employeeSet;
	
	@Before
	public void setup() {
		assignment = new OptionalAssignment();
		employeeSet = EmployeeGenerator.employeeSet1();
	}
	
	@Test
	public void testFindEmployee() {
		Optional<Employee> actual = assignment.findEmployee(employeeSet, x -> x.getAge() >= 30 && x.getAge() < 40);
		
		Set<Employee> expected = new HashSet<>();
		expected.add(new Employee("Carolyn", "Figueroa", 31, JUNIOR));
		expected.add(new Employee("Lionel", "Myers", 39, REGULAR));
		expected.add(new Employee("Ada", "Sullivan", 35, SENIOR));
		
		assertNotNull(actual);
		assertTrue(expected.contains(actual.get()));
		
		
		Set<Employee> notExpected = new HashSet<>();
		notExpected.add(new Employee("Henrietta", "Ferguson", 19, JUNIOR));
		notExpected.add(new Employee("Vivian", "Elliott", 25, JUNIOR));
		notExpected.add(new Employee("Jermaine", "Wilkerson", 24, JUNIOR));
		notExpected.add(new Employee("Darren", "Lawson", 42, SENIOR));
		notExpected.add(new Employee("Rickey", "Castro", 55, SENIOR));
		
		assertFalse(notExpected.contains(actual.get()));
	}
	
	@Test
	public void testFindEmployeeEmpty() {
		Optional<Employee> actual = assignment.findEmployee(employeeSet, x -> x.getAge() > 200);
		assertEquals(Optional.empty(), actual);
	}
	
	@Test
	public void testFindEmployeeName() {
		String actual = assignment.findEmployeeName(employeeSet, x -> x.getAge() >= 30 && x.getAge() < 40);
		List<String> expected = Arrays.asList("Figueroa", "Myers", "Sullivan");
		
		assertTrue(expected.contains(actual));
		assertNotEquals(OptionalAssignment.NOT_FOUND_MESSAGE, actual);
	}
	
	@Test
	public void testFindEmployeeNameNotFound() {
		String actual = assignment.findEmployeeName(employeeSet, x -> x.getAge() > 200);
		
		assertEquals(OptionalAssignment.NOT_FOUND_MESSAGE, actual);
	}
}
