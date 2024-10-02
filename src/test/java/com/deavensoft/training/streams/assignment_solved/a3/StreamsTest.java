package com.deavensoft.training.streams.assignment_solved.a3;

import static com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Position.JUNIOR;
import static com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Position.REGULAR;
import static com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Position.SENIOR;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Employee;
import com.deavensoft.training.streams.assignment_solved.modelanddata.employee.EmployeeGenerator;
import com.deavensoft.training.streams.assignment_solved.modelanddata.employee.Position;

public class StreamsTest {
	private StreamsAssignment assignment;
	private Set<Employee> employeeSet1;
	private Set<Employee> employeeSet2;
	
	@Before
	public void prepareData() {
		assignment = new StreamsAssignment();
		employeeSet1 = EmployeeGenerator.employeeSet1();
		employeeSet2 = EmployeeGenerator.employeeSet2();
	}	
	
	@Test
	public void testGroupEmployeesByPositions() {
		Map<Position, Set<Employee>> expected = new HashMap<>();
		expected.put(JUNIOR, EmployeeGenerator.employeeSet1Juniors());
		expected.put(REGULAR, EmployeeGenerator.employeeSet1Regulars());
		expected.put(SENIOR, EmployeeGenerator.employeeSet1Seniors());

		
		Map<Position, Set<Employee>> actual = assignment.groupEmployeesByPositions(employeeSet1);
		
		assertEquals(expected, actual);

	}
	
	@Test
	public void testGroupEmployeesByPositions2() {
		Map<Position, Set<Employee>> expected = new HashMap<>();
		expected.put(JUNIOR, EmployeeGenerator.employeeSet2Juniors());
		expected.put(REGULAR, EmployeeGenerator.employeeSet2Regulars());
		expected.put(SENIOR, EmployeeGenerator.employeeSet2Seniors());
		
		Map<Position, Set<Employee>> actual = assignment.groupEmployeesByPositions(employeeSet2);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testFindEmployees() {
		Set<Employee> actual = assignment.findEmployees(employeeSet1, new Predicate<Employee>() {
			@Override
			public boolean test(Employee e) {
				return e.getLastname().toLowerCase().startsWith("f");
			}
		});
		
		Set<Employee> expected = new HashSet<>();
		expected.add(new Employee("Carolyn", "Figueroa", 31, JUNIOR));
		expected.add(new Employee("Henrietta", "Ferguson", 19, JUNIOR));
		expected.add(new Employee("Kara", "Ferguson", 29, REGULAR));
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testFindEmployees2() {
		Set<Employee> actual = assignment.findEmployees(employeeSet1, new Predicate<Employee>() {
			@Override
			public boolean test(Employee e) {
				return e.getAge() < 30;
			}
		});
		
		Set<Employee> expected = new HashSet<>();
		expected.add(new Employee("Kara", "Ferguson", 29, REGULAR));
		expected.add(new Employee("Kara", "Ferguson", 29, REGULAR));
		expected.add(new Employee("Lucille", "Harrington", 25, JUNIOR));
		expected.add(new Employee("Henrietta", "Ferguson", 19, JUNIOR));
		expected.add(new Employee("Vivian", "Elliott", 25, JUNIOR));
		expected.add(new Employee("Jermaine", "Wilkerson", 24, JUNIOR));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSumAllEvenNumbers() {
		Set<Integer> numbers = IntStream.iterate(1, i -> i + 1)
				.boxed()
				.limit(10)
				.collect(Collectors.toSet());
		
		Integer actual = assignment.sumAllEvenNumbers(numbers);
		
		Integer expected = 30;
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testSumAllEvenNumbers2() {
		Set<Integer> numbers = IntStream.iterate(1, i -> i + 1)
				.boxed()
				.limit(20)
				.collect(Collectors.toSet());
		
		Integer actual = assignment.sumAllEvenNumbers(numbers);
		
		Integer expected = 110;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPartitionSeniors() {
		Map<Boolean, Set<Employee>> actual = assignment.partitionSeniors(employeeSet1);
		
		Map<Boolean, Set<Employee>> expected = new HashMap<>();
		expected.put(Boolean.TRUE, EmployeeGenerator.employeeSet1Seniors());
		expected.put(Boolean.FALSE, EmployeeGenerator.employeeSet1Juniors());
		expected.get(Boolean.FALSE).addAll(EmployeeGenerator.employeeSet1Regulars());
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPartitionSeniors2() {
		Map<Boolean, Set<Employee>> actual = assignment.partitionSeniors(employeeSet2);
		
		Map<Boolean, Set<Employee>> expected = new HashMap<>();
		expected.put(Boolean.TRUE, EmployeeGenerator.employeeSet2Seniors());
		expected.put(Boolean.FALSE, EmployeeGenerator.employeeSet2Juniors());
		expected.get(Boolean.FALSE).addAll(EmployeeGenerator.employeeSet2Regulars());
		
		assertEquals(expected, actual);
	}
}
