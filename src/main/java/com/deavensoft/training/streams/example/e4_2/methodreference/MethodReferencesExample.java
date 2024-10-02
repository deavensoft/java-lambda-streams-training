package com.deavensoft.training.streams.example.e4_2.methodreference;

import java.util.ArrayList;
import java.util.List;

import com.deavensoft.training.streams.example.e2.imperativeprogramming.Employee;
import com.deavensoft.training.streams.example.e2.imperativeprogramming.EmployeeGenerator;

public class MethodReferencesExample {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>(EmployeeGenerator.generate());

		
//		List<String> employeeAges = 
//		
//		EmployeeGenerator.print(employeeAges);
//		
//		List<String> employeeLastnames = 
//		
//		EmployeeGenerator.print(employeeLastnames);
//		
//		List<String> employeeNames = 
//		
//		EmployeeGenerator.print(employeeNames);

	}

}
