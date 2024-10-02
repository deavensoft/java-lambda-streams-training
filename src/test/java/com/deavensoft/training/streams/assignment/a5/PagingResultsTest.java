package com.deavensoft.training.streams.assignment.a5;

import static com.deavensoft.training.streams.assignment.modelanddata.employee.Position.JUNIOR;
import static com.deavensoft.training.streams.assignment.modelanddata.employee.Position.REGULAR;
import static com.deavensoft.training.streams.assignment.modelanddata.employee.Position.SENIOR;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.deavensoft.training.streams.assignment.modelanddata.employee.Employee;
import com.deavensoft.training.streams.assignment.modelanddata.employee.EmployeeGenerator;
import static org.junit.Assert.*;

public class PagingResultsTest {

	private PagingResultsAssignment assignment;
	private Set<Employee> employeeSet;
	
	@Before
	public void before() {
		assignment = new PagingResultsAssignment();
		employeeSet = EmployeeGenerator.employeeSet1();
	}
	
	@Test
	public void testSortedEmployeesStream() {
		Stream<Employee> stream = assignment.sortedEmployeesStream(employeeSet, compareByFirstname);
		assertNotNull(stream);
		
		List<Employee> actual = stream
				.collect(Collectors.toList());
		assertEquals(employeeListSortedByFirstname(), actual);
	}
	
	@Test
	public void testSortByLastname() {
		employeeSet.removeIf(e -> e.getLastname().equals("Ferguson")); // remove duplicated lastname
		List<Employee> actual = assignment.sortByLastname(employeeSet);
		assertEquals(employeeListSortedByLastname(), actual);
	}
	
	
	@Test
	public void testPagedResult1() {
		List<Employee> actual = assignment.pagedResult(employeeSet, compareByFirstname, 5, 2);
		
		List<Employee> expected = new ArrayList<>();
		expected.add(new Employee("Kara", "Ferguson", 29, REGULAR));
		expected.add(new Employee("Lionel", "Myers", 39, REGULAR));
		expected.add(new Employee("Lucille", "Harrington", 25, JUNIOR));
		expected.add(new Employee("Rickey", "Castro", 55, SENIOR));
		expected.add(new Employee("Vivian", "Elliott", 25, JUNIOR));
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testPagedResult2() {
		List<Employee> actual = assignment.pagedResult(employeeSet, compareByFirstname, 5, 100);
		List<Employee> expected = new ArrayList<>();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testPagedResult3() {
		List<Employee> actual = assignment.pagedResult(employeeSet, compareByFirstname, 3, 4);
		
		List<Employee> expected = new ArrayList<>();
		expected.add(new Employee("Vivian", "Elliott", 25, JUNIOR));
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testPagedResult4() {
		List<Employee> actual = assignment.pagedResult(employeeSet, compareByAge, 3, 1);
		
		List<Employee> expected = new ArrayList<>();
		expected.add(new Employee("Henrietta", "Ferguson", 19, JUNIOR));
		expected.add(new Employee("Jermaine", "Wilkerson", 24, JUNIOR));
		expected.add(new Employee("Vivian", "Elliott", 25, JUNIOR));
		
		assertEquals(expected, actual);
		
	}
	
	private List<Employee> employeeListSortedByFirstname() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Ada", "Sullivan", 35, SENIOR));
		list.add(new Employee("Carolyn", "Figueroa", 31, JUNIOR));
		list.add(new Employee("Darren", "Lawson", 42, SENIOR));
		list.add(new Employee("Henrietta", "Ferguson", 19, JUNIOR));
		list.add(new Employee("Jermaine", "Wilkerson", 24, JUNIOR));
		list.add(new Employee("Kara", "Ferguson", 29, REGULAR));
		list.add(new Employee("Lionel", "Myers", 39, REGULAR));
		list.add(new Employee("Lucille", "Harrington", 25, JUNIOR));
		list.add(new Employee("Rickey", "Castro", 55, SENIOR));
		list.add(new Employee("Vivian", "Elliott", 25, JUNIOR));
		return list;
	}
	
	private List<Employee> employeeListSortedByLastname() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Rickey", "Castro", 55, SENIOR));
		list.add(new Employee("Vivian", "Elliott", 25, JUNIOR));
		list.add(new Employee("Carolyn", "Figueroa", 31, JUNIOR));
		list.add(new Employee("Lucille", "Harrington", 25, JUNIOR));
		list.add(new Employee("Darren", "Lawson", 42, SENIOR));
		list.add(new Employee("Lionel", "Myers", 39, REGULAR));
		list.add(new Employee("Ada", "Sullivan", 35, SENIOR));
		list.add(new Employee("Jermaine", "Wilkerson", 24, JUNIOR));
		return list;
	}
	
	private final Comparator<Employee> compareByFirstname = new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getFirstname().compareTo(e2.getFirstname());
		}
	};

	private final Comparator<Employee> compareByAge = Comparator.comparing(Employee::getAge)
			.thenComparing(Employee::getFirstname);
}
