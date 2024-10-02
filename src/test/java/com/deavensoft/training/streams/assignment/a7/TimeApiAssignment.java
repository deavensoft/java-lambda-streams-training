package com.deavensoft.training.streams.assignment.a7;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * The purpose of this assignment is to try new Java 8 Date/Time API methods.
 * 
 * @author drazen
 *
 */
public class TimeApiAssignment {
	
	/**
	 * Check is the given date within give date period (inclusive start and inclusive end day).
	 * The period is defined by the startDate and Period length.
	 * 
	 * @param date Date to check.
	 * @param startDate Start date of period.
	 * @param period Period object.
	 * 
	 * @return true if input date is within given period; false otherwise.
	 */
	public boolean isDateWithinPeriod(LocalDate date, LocalDate startDate, Period period) {
		// TODO - implement
		return false;
	}
	
	
	/**
	 * Finds all dates from the input set of dates
	 * which are after the specified startingDate (as String, 
	 * in format yyyy-MM-dd - {@link DateTimeFormatter#ISO_LOCAL_DATE}).
	 * 
	 * 
	 * @param dates Input set of dates.
	 * @param startingDate Date to use for comparation. 
	 * Format: yyyy-MM-dd - {@link DateTimeFormatter#ISO_LOCAL_DATE}).
	 * 
	 * @return Set of dates which are after startingDate
	 */
	public Set<LocalDate> findDatesAfter(Set<LocalDate> dates, String startingDate) {
		// TODO - implement
		return null;
	}

}
