package com.deavensoft.training.streams.assignment_solved.a1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Employee;
import com.deavensoft.training.streams.assignment_solved.modelanddata.employee.EmployeeGenerator;

import static com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Position.*;
import static org.junit.Assert.*;

public class LambdaExpressionsTest {
	private LambdaExpressionsAssignment assignment;
	private Set<Employee> employeeSet1;
	private Set<Employee> employeeSet2;
	
	@Before
	public void prepareData() {
		assignment = new LambdaExpressionsAssignment();
		employeeSet1 = EmployeeGenerator.employeeSet1();
		employeeSet2 = EmployeeGenerator.employeeSet2();
	}
	

	@Test
	public void testEmployeeByAgeComparator() {
		Employee e1 = new Employee("Young", "Castro", 25, JUNIOR);
		Employee e2 = new Employee("Old", "Castro", 55, SENIOR);
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.sort(assignment.employeeByAgeComparator);
		assertTrue(employeeList.get(0).equals(e1));
	}
	
	@Test
	public void testFindOldest() {
		Employee oldestEmployee = new Employee("Rickey", "Castro", 55, SENIOR);
		assertEquals(oldestEmployee, assignment.findOldest(employeeSet1));
	}
	
	@Test
	public void testFindOldest2() {
		Employee oldestEmployee1 = new Employee("Nicholas", "Rodgers", 48, SENIOR);
		Employee oldestEmployee2 = new Employee("Jerome", "Mcbride", 48, SENIOR);
		Employee result = assignment.findOldest(employeeSet2);
		assertTrue(result.equals(oldestEmployee1) || result.equals(oldestEmployee2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFindOldestByPositionExceptionThrown() {
		assignment.findOldestByPosition(employeeSet1, null); 
	}
	
	@Test
	public void testFindOldestByPosition() {
		Employee oldestEmployee = new Employee("Rickey", "Castro", 55, SENIOR);
		assertEquals(oldestEmployee, assignment.findOldestByPosition(employeeSet1, SENIOR));
	}
	
	@Test
	public void testFindOldestByPosition2() {
		Employee oldestEmployee = new Employee("Carolyn", "Figueroa", 31, JUNIOR);
		assertEquals(oldestEmployee, assignment.findOldestByPosition(employeeSet1, JUNIOR));
	}
	
	@Test
	public void testFindOldestByPosition3() {
		Employee oldestEmployee = new Employee("Doreen", "Grant", 35, REGULAR);
		assertEquals(oldestEmployee, assignment.findOldestByPosition(employeeSet2, REGULAR));
	}

}
