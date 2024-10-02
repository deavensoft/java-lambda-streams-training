package com.deavensoft.training.streams.example.e2.imperativeprogramming;

import static com.deavensoft.training.streams.example.e2.imperativeprogramming.Position.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class ImperativeExample {

	/**
	 * Find all senior employees from the set of employees.
	 */
	@Test
	public void findAllSeniors () {
		
		Set<Employee> employees = EmployeeGenerator.generate();
		
		// filter SENIOR employees
		Set<Employee> seniors = new HashSet<>();
		
		for (Employee employee : employees) {
			if (employee.getPosition().equals(SENIOR)) {
				seniors.add(employee);
			}
		}
		
		EmployeeGenerator.print(seniors);
		
	}
	
	/**
	 * Find the average age of junior employees
	 */
	@Test
	public void findAverageAgeOfJuniors() {
		
		Set<Employee> employees = EmployeeGenerator.generate();
		
		// filter JUNIOR employees
		Set<Employee> juniors = new HashSet<>();
		
		for (Employee employee : employees) {
			if (employee.getPosition().equals(JUNIOR)) {
				juniors.add(employee);
			}
		}
		
		// calculate average age
		double accumulator = 0;
		
		for (Employee employee : juniors) {
			accumulator += employee.getAge();
		}
		
		System.out.println(accumulator / juniors.size());
		
	}
	
	/**
	 * Finds the age of the oldest Employee within each 
	 * employee group represented by Position.
	 */
	@Test
	public void findOldestAgeWithinEachGroup() {
		
		Set<Employee> employees = EmployeeGenerator.generate();
		
		// group Employees by position
		Map<Position, Set<Employee>> groupped = new HashMap<>();
		
		for (Employee employee : employees) {
			Position position = employee.getPosition();
			
			Set<Employee> withinGroup = groupped.get(position); // get Set of Employees within one Position
			
			if (withinGroup == null) { // create/initialize if not found
				withinGroup = new HashSet<>();
				groupped.put(position, withinGroup);
			}
			
			withinGroup.add(employee);
		}
		
		// calculate max age per group
		for (Position position : groupped.keySet()) {
			int maxAge = 0;
			for (Employee employee : groupped.get(position)) {
				if (employee.getAge() > maxAge) {
					maxAge = employee.getAge();
				}
			}
			System.out.println(position + ", " + maxAge);
		}
		
	}

	


/*
  	-- SQL create:
	create table position (id INTEGER, name VARCHAR(50));
	INSERT INTO position VALUES (1, 'JUNIOR');
	INSERT INTO position VALUES (2, 'REGULAR');
	INSERT INTO position VALUES (3, 'SENIOR');

	create table employee (id INTEGER, firstname VARCHAR(50), lastname VARCHAR(50), age INTEGER, position_id INTEGER);
	INSERT INTO employee VALUES (1, 'Lucille', 'Harrington', 25, 1);
	INSERT INTO employee VALUES (2, 'Carolyn', 'Figueroa', 31, 1);
	INSERT INTO employee VALUES (3, 'Henrietta', 'Ferguson', 19, 1);
	INSERT INTO employee VALUES (4, 'Vivian', 'Elliott', 25, 1);
	INSERT INTO employee VALUES (5, 'Jermaine', 'Wilkerson', 24, 1);
	INSERT INTO employee VALUES (6, 'Kara', 'Ferguson', 29, 2);
	INSERT INTO employee VALUES (7, 'Lionel', 'Myers', 39, 2);
	INSERT INTO employee VALUES (8, 'Ada', 'Sullivan', 35, 3);
	INSERT INTO employee VALUES (9, 'Darren', 'Lawson', 42, 3);
	INSERT INTO employee VALUES (10, 'Rickey', 'Castro', 55, 3);

	
	-- findAllSeniors() SQL:
	SELECT e.firstname, e.lastname, e.age, p.name AS position
	  FROM employee e JOIN position p ON e.position_id = p.id
	 WHERE p.name = 'SENIOR';
	 
	 
	-- findAverageAgeOfJuniors() SQL:
	SELECT AVG(CAST (e.age AS DOUBLE PRECISION))
	  FROM employee e JOIN position p ON e.position_id = p.id
	 WHERE p.name = 'JUNIOR';
	 
	-- findOldestAgeWithinEachGroup() SQL:
  	SELECT p.name, MAX(e.age)
	  FROM employee e JOIN position p ON e.position_id = p.id
	 GROUP BY p.name	
		
	-- EXPLAIN PLAN FOR
*/
}
