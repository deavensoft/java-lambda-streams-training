package com.deavensoft.training.streams.example.e9.timeapi;

import java.time.Clock;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class TimeApiExample {

	public static void main(String... args) {
		// How to get today's date
		LocalDate today = LocalDate.now();
		System.out.println("Today's Local date : " + today);

		// How to get current day, month and year
		today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);

		// How to get a particular date
		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
		System.out.println("Your Date of birth is : " + dateOfBirth);

		// How to check if two dates are equal
		LocalDate date1 = LocalDate.of(2016, 03, 19);
		if (date1.equals(today)) {
			System.out.printf("Today %s and date1 %s are same date %n", today, date1);
		} else {
			System.out.printf("Today %s and date1 %s are NOT the same%n", today, date1);
		}

		// How to check for recurring events e.g. birthday
		dateOfBirth = LocalDate.of(1978, 03, 16);
		MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		MonthDay currentMonthDay = MonthDay.from(today);
		if (currentMonthDay.equals(birthday)) {
			System.out.println("Many Many happy returns of the day !!");
		} else {
			System.out.println("Sorry, today is not your birthday");
		}

		
		// How to get current Time
		LocalTime time = LocalTime.now(); 
		System.out.println("local time now : " + time);
		
		
		// How to add hours in time
		time = LocalTime.now(); 
		LocalTime newTime = time.plusHours(2); // adding two hours 
		System.out.println("Time after 2 hours : " + newTime);

		
		
		// How to find Date after 1 week
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS); 
//		LocalDate nextWeek = today.plusWeeks(1);
		System.out.println("Today is : " + today);
		System.out.println("Date after 1 week : " + nextWeek);


		// Date before and after 1 year
		LocalDate previousYear = today.minus(1, ChronoUnit.YEARS); 
//		LocalDate previousYear = today.minusYears(1);
		System.out.println("Date before 1 year : " + previousYear);
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS); 
		System.out.println("Date after 1 year : " + nextYear);

		
		// Using Clock
		// Returns the current time based on your system clock and set to UTC. 
		Clock clock = Clock.systemUTC(); 
		System.out.println("Clock : " + clock); // Returns time based on system clock zone 
		Clock defaultClock = Clock.systemDefaultZone(); 
		System.out.println("Clock (default zone): " + defaultClock);

		
		// How to see if a date is before or after another dates
		LocalDate tomorrow = LocalDate.of(2016, 3, 15); 
		if(tomorrow.isAfter(today)){ 
			System.out.println("Tomorrow comes after today"); 
		} 
		LocalDate yesterday = today.minus(1, ChronoUnit.DAYS); 
		if(yesterday.isBefore(today)){ 
			System.out.println("Yesterday is day before today"); 
		}

		
		// Dealing with time zones
		ZoneId america = ZoneId.of("America/New_York"); 
		LocalDateTime localtDateAndTime = LocalDateTime.now(); 
		ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, america ); 
		System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork); 

		
		// How to represent fixed date e.g. credit card expiry, YearMonth
		YearMonth currentYearMonth = YearMonth.now(); 
		System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth()); 
		YearMonth creditCardExpiry = YearMonth.of(2024, Month.FEBRUARY);
		System.out.printf("Your credit card expires on %s %n", creditCardExpiry); 
		
		
		// How to check Leap Year
		if(today.isLeapYear()){ 
			System.out.println("This year is Leap year"); 
		} else { 
			System.out.println("2014 is not a Leap year"); 
		}

		
		// How many days, month between two dates
		today = LocalDate.now();
		LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14); 
		Period periodAfterJavaRelease = Period.between(java8Release, today); 
		System.out.println("Months after Java 8 release (until today): " + periodAfterJavaRelease.toTotalMonths()  + " months");

		
		// Date and Time with timezone offset
		LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14, 19, 30); 
		ZoneOffset offset = ZoneOffset.of("+05:30"); 
		OffsetDateTime date = OffsetDateTime.of(datetime, offset); 
		System.out.println("Date and Time with timezone offset in Java : " + date);

		
		// How to get current time stamp
		Instant timestamp = Instant.now(); 
		System.out.println("What is value of this instant " + timestamp);
		
		
		// How to parse/format date in Java 8 using predefined formatter
		String dayAfterTommorrow = "20140116"; 
		LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE); 
		System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);


		
		// How to parse date in Java using custom formatter
		String goodFriday = "Apr 29 2016"; 
		try { 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy"); 
			LocalDate holiday = LocalDate.parse(goodFriday, formatter); 
			System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday); 
		} catch (DateTimeParseException ex) { 
			System.out.printf("%s is not parsable!%n", goodFriday); ex.printStackTrace(); 
		}

		
		// How to convert Date to String in Java 8, formatting dates
		LocalDateTime arrivalDate = LocalDateTime.now(); 
		try { 
			DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a"); 
			String landing = arrivalDate.format(format); 
			System.out.printf("Arriving at : %s %n", landing); 
		} catch (DateTimeException ex) { 
			System.out.printf("%s can't be formatted!%n", arrivalDate); 
			ex.printStackTrace(); 
		}

		
	}
}
