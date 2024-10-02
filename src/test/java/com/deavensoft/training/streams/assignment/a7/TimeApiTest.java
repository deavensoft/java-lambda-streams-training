package com.deavensoft.training.streams.assignment.a7;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeApiTest {

	TimeApiAssignment assignment;
	
	@Before
	public void setup() {
		assignment = new TimeApiAssignment();
	}

	
	@Test
	public void testIsDateWithinPeriod() {
		LocalDate startDate = LocalDate.of(2016, 3, 19);
		Period period = Period.ofDays(30);
		assertTrue(assignment.isDateWithinPeriod(LocalDate.of(2016, 3, 30), startDate, period));
		assertTrue(assignment.isDateWithinPeriod(LocalDate.of(2016, 3, 19), startDate, period));
		assertTrue(assignment.isDateWithinPeriod(LocalDate.of(2016, 4, 15), startDate, period));
		assertFalse(assignment.isDateWithinPeriod(LocalDate.of(2016, 2, 15), startDate, period));
		assertFalse(assignment.isDateWithinPeriod(LocalDate.of(2016, 4, 25), startDate, period));
	}
	
	
	@Test
	public void testFindDatesAfter() {
		Set<LocalDate> dates = new HashSet<>();
		dates.add(LocalDate.of(2016, 3, 20));
		dates.add(LocalDate.of(2016, 1, 29));
		dates.add(LocalDate.of(2015, 8, 2));
		dates.add(LocalDate.of(2018, 3, 1));
		
		String startingDate = "2016-03-19";
		Set<LocalDate> actual = assignment.findDatesAfter(dates, startingDate);
		
		Set<LocalDate> expected = new HashSet<>();
		expected.add(LocalDate.of(2016, 3, 20));
		expected.add(LocalDate.of(2018, 3, 1));
		
		
		assertEquals(expected, actual);
	}
}
