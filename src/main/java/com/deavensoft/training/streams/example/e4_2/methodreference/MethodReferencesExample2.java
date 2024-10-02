package com.deavensoft.training.streams.example.e4_2.methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.deavensoft.training.streams.example.e2.imperativeprogramming.Employee;
import com.deavensoft.training.streams.example.e2.imperativeprogramming.EmployeeGenerator;
import com.deavensoft.training.streams.example.e2.imperativeprogramming.Position;

public class MethodReferencesExample2 {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>(EmployeeGenerator.generate());

		
		List<String> employeeAges = employees.stream()
				.map(e -> e.getAge())
				.map(String::valueOf) // static method reference
				.collect(Collectors.toList());
		
		EmployeeGenerator.print(employeeAges);
		
		List<String> employeeLastnames = employees.stream()
				.map(e -> e.getLastname())
				.map(String::toUpperCase) // instance method reference 
				.collect(Collectors.toList());
		
		EmployeeGenerator.print(employeeLastnames);
		
		List<String> employeeNames = employees.stream()
				.map(Employee::getFullName) // own instance method reference
				.collect(Collectors.toList());
		
		EmployeeGenerator.print(employeeNames);

		
		int sumAgesOfSeniors = employees.stream()
				.filter(e -> e.getPosition().equals(Position.SENIOR))
				.peek(System.out::println)
				.mapToInt(e -> e.getAge())
//				.reduce(0, (acc, age) -> Integer.sum(acc, age));
				.reduce(0, Integer::sum); // two arguments method reference
		
		System.out.println(sumAgesOfSeniors);
	}

}
