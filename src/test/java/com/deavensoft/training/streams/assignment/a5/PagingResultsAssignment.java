package com.deavensoft.training.streams.assignment.a5;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import com.deavensoft.training.streams.assignment.modelanddata.employee.Employee;

public class PagingResultsAssignment {

	/**
	 * Sort employees by the given comparator using Stream API.
	 * 
	 * @param employeeSet Set of employees.
	 * @param comparator Comparator to sort the stream by.
	 * 
	 * @return Stream of sorted List of Employees.
	 */
	public Stream<Employee> sortedEmployeesStream(Set<Employee> employeeSet, Comparator<Employee> comparator) {
		return null; // IMPLEMENT METHOD
	}
	
	
	/**
	 * Sort input set of Employees by Lastname.
	 * Use previously implemented {@link this#sort(Set, Comparator)} method and
	 * write a proper lambda expression of the comparator functional interface.
	 * 
	 * @param employeeSet Set of employees.
	 * 
	 * @return Sorted List of Employees.
	 */
	public List<Employee> sortByLastname(Set<Employee> employeeSet) {
		return null; // IMPLEMENT METHOD
	}
	
	/**
	 * Method used to page results (in this case Employees), e.g. like search results which are paged.
	 * 
	 * The method should first sort the Employees (represented as a Set of Employees, like un-ordered records in the DB).
	 * Then it should return a subset of the results for the given page
	 * 
	 * @param employeeSet All results (employees). Unordered.
	 * @param comparator Comparator to use for employee sorting.
	 * @param resultsPerPage Number of results for each page.
	 * @param pageNumber Page number to ger results for (starts with 1).
	 * 
	 * @return Subset of input employeeSet which is sorted, for the given page.
	 */
	public List<Employee> pagedResult(Set<Employee> employeeSet, Comparator<Employee> comparator, 
			int resultsPerPage, int pageNumber) {
		
		return null; // IMPLEMENT METHOD
	}
}
