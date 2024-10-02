package com.deavensoft.training.streams.example.e2.imperativeprogramming;

import static com.deavensoft.training.streams.example.e2.imperativeprogramming.Position.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class EmployeeGenerator {

	public static Set<Employee> generate() {
		Set<Employee> employeeSet = new HashSet<>();
		employeeSet.addAll(employeeSet1Juniors());
		employeeSet.addAll(employeeSet1Regulars());
		employeeSet.addAll(employeeSet1Seniors());
		return employeeSet;
	}
	
	public static Set<Employee> employeeSet1Juniors() {
		Set<Employee> juniorSet = new HashSet<>();
		juniorSet.add(new Employee("Lucille", "Harrington", 25, JUNIOR));
		juniorSet.add(new Employee("Carolyn", "Figueroa", 31, JUNIOR));
		juniorSet.add(new Employee("Henrietta", "Ferguson", 19, JUNIOR));
		juniorSet.add(new Employee("Vivian", "Elliott", 25, JUNIOR));
		juniorSet.add(new Employee("Jermaine", "Wilkerson", 24, JUNIOR));
		return juniorSet;
	}
	public static Set<Employee> employeeSet1Regulars() {
		Set<Employee> regularSet = new HashSet<>();
		regularSet.add(new Employee("Kara", "Ferguson", 29, REGULAR));
		regularSet.add(new Employee("Lionel", "Myers", 39, REGULAR));
		return regularSet;
	}
	public static Set<Employee> employeeSet1Seniors() {
		Set<Employee> seniorSet = new HashSet<>();
		seniorSet.add(new Employee("Ada", "Sullivan", 35, SENIOR));
		seniorSet.add(new Employee("Darren", "Lawson", 42, SENIOR));
		seniorSet.add(new Employee("Rickey", "Castro", 55, SENIOR));
		return seniorSet;
	}
	
	public static Set<Employee> employeeSet2() {
		Set<Employee> employeeSet = new HashSet<>();
		employeeSet.addAll(employeeSet2Juniors());
		employeeSet.addAll(employeeSet2Regulars());
		employeeSet.addAll(employeeSet2Seniors());
		return employeeSet;
	}
	
	public static Set<Employee> employeeSet2Juniors() {
		Set<Employee> juniorSet = new HashSet<>();
		juniorSet.add(new Employee("Bonnie", "Cain", 23, JUNIOR));
		juniorSet.add(new Employee("Abraham", "Burton", 26, JUNIOR));
		juniorSet.add(new Employee("Johnnie", "Holmes", 30, JUNIOR));
		juniorSet.add(new Employee("Mattie", "Carpenter", 25, JUNIOR));
		return juniorSet;
	}
	public static Set<Employee> employeeSet2Regulars() {
		Set<Employee> regularSet = new HashSet<>();
		regularSet.add(new Employee("Lynn", "Ramsey", 25, REGULAR));
		regularSet.add(new Employee("Milton", "Barber", 29, REGULAR));
		regularSet.add(new Employee("Doreen", "Grant", 35, REGULAR));
		return regularSet;
	}
	public static Set<Employee> employeeSet2Seniors() {
		Set<Employee> seniorSet = new HashSet<>();
		seniorSet.add(new Employee("Sonja", "Williams", 32, SENIOR));
		seniorSet.add(new Employee("Nicholas", "Rodgers", 48, SENIOR));
		seniorSet.add(new Employee("Jerome", "Mcbride", 48, SENIOR));
		return seniorSet;
	}	
	

	/**
	 * Helper method for printing
	 * 
	 * @param collection collection to print
	 */
	public static <T> void  print(Collection<T> collection) {
		for (T object : collection) {
			System.out.println(object);
		}
	}
}
