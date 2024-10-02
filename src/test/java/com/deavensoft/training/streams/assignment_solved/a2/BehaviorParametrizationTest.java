package com.deavensoft.training.streams.assignment_solved.a2;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Employee;
import com.deavensoft.training.streams.assignment_solved.modelanddata.employee.EmployeeGenerator;

import static com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Position.*;
import static org.junit.Assert.*;

public class BehaviorParametrizationTest {
	private  BehaviorParametrizationAssignment assignment;
	private Set<Employee> employeeSet1;
	private Set<Employee> employeeSet2;
	
	@Before
	public void prepareData() {
		assignment = new BehaviorParametrizationAssignment();
		employeeSet1 = EmployeeGenerator.employeeSet1();
		employeeSet2 = EmployeeGenerator.employeeSet2();
	}
	
	@Test
	public void testFilterEmployeesByPosition() {
		Set<Employee> actual = assignment.filterEmployeesByPosition(employeeSet1, SENIOR);
		assertEquals(EmployeeGenerator.employeeSet1Seniors(), actual);
	}
	
	@Test
	public void testFilterEmployeesByPosition2() {
		Set<Employee> actual = assignment.filterEmployeesByPosition(employeeSet2, JUNIOR);
		assertEquals(EmployeeGenerator.employeeSet2Juniors(), actual);
	}
	
	@Test
	public void testFilterEmployeesByAgeDecade() {
		Set<Employee> expected = new HashSet<>();
		expected.add(new Employee("Lucille", "Harrington", 25, JUNIOR));
		expected.add(new Employee("Vivian", "Elliott", 25, JUNIOR));
		expected.add(new Employee("Jermaine", "Wilkerson", 24, JUNIOR));
		expected.add(new Employee("Kara", "Ferguson", 29, REGULAR));

		Set<Employee> actual = assignment.filterEmployeesByAgeDecade(employeeSet1, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFilterEmployeesByAgeDecade2() {
		Set<Employee> expected = new HashSet<>();
		expected.add(new Employee("Henrietta", "Ferguson", 19, JUNIOR));
		
		Set<Employee> actual = assignment.filterEmployeesByAgeDecade(employeeSet1, 2);
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testFilterEmployeesByAgeDecade3() {
		Set<Employee> expected = new HashSet<>();
		expected.add(new Employee("Nicholas", "Rodgers", 48, SENIOR));
		expected.add(new Employee("Jerome", "Mcbride", 48, SENIOR));
		
		Set<Employee> actual = assignment.filterEmployeesByAgeDecade(employeeSet2, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFilterEmployeesByLastnameLetter() {
		Set<Employee> expected = new HashSet<>();
		expected.add(new Employee("Carolyn", "Figueroa", 31, JUNIOR));
		expected.add(new Employee("Henrietta", "Ferguson", 19, JUNIOR));
		expected.add(new Employee("Kara", "Ferguson", 29, REGULAR));
		
		Set<Employee> actual = assignment.filterEmployeesByLastnameLetter(employeeSet1, 'F');
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFilterEmployeesByLastnameLetter2() {
		Set<Employee> expected = new HashSet<>();
		expected.add(new Employee("Abraham", "Burton", 26, JUNIOR));
		expected.add(new Employee("Milton", "Barber", 29, REGULAR));
	
		Set<Employee> actual = assignment.filterEmployeesByLastnameLetter(employeeSet2, 'B');
		assertEquals(expected, actual);
	}
}
