package com.deavensoft.training.streams.example.e4_0.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.deavensoft.training.streams.example.e2.imperativeprogramming.Employee;
import com.deavensoft.training.streams.example.e2.imperativeprogramming.EmployeeGenerator;

public class Lambda2 {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>(EmployeeGenerator.generate()); 
		
		// sort by employee lastname
		employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                // assuming e1.getLastname() is not null
                return e1.getLastname().compareTo(e2.getLastname());
            }

        });
		
		EmployeeGenerator.print(employees);
	}
}
