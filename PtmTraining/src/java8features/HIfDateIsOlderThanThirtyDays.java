package java8features;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

//1-3 : java.time 
//Example 1 : isBefore
//Example 2 : ChronoUnit.MONTHS.between
//Example 3 : Period
//4 : java.util
//Example 4 : Calendar
public class HIfDateIsOlderThanThirtyDays {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		//Example 1 :: Java 8 isBefore()
		//First backdate a date to 6 months old
		//then check if the test date isBefore the 6 months old date
		
		LocalDate currDate = LocalDate.now();
		LocalDate currDateMinus6Months = currDate.minusMonths(6);
		
		System.out.println("currentDate : " + currDate);
		System.out.println("Curr minus 6 months : " + currDateMinus6Months);
		
//		LocalDate date1 = LocalDate.of(2021, 7, 13);
		LocalDate date1 = currDateMinus6Months.minusDays(1);
		System.out.println("\ndate1 : " + date1);
		if(date1.isBefore(currDateMinus6Months)) {
			System.out.println("6 months older than current date");
		}
		
		
		
		//Example 2 :: Java 8 ChronoUnit.{UNIT}.between
		long months = ChronoUnit.MONTHS.between(currDate, date1);
		System.out.println(months);
		if(months<=-6) {
			System.out.println("6 months older than current date");
		}
		
		
		
		//Example 3 :: Java 8 Period.between
		Period period = Period.between(currDate, date1);
		String result = String.format("%d years, %d months, %d days", period.getYears(), period.getMonths(), period.getDays());
		System.out.println(result);
		
		
		//Example 4 :: Legacy Calendar and Date
		//Check if java.util.calender is 6 month older
		Calendar sixMonthsAgo = Calendar.getInstance();
		System.out.println("\n\nnow : " + sdf.format(sixMonthsAgo.getTime()));
		sixMonthsAgo.add(Calendar.MONTH, -6);
		System.out.println("sixMonthsAgo : " + sdf.format(sixMonthsAgo.getTime()));
		
		Calendar dateC = new GregorianCalendar(2021, Calendar.JULY, 13);
		System.out.println("date C : " + sdf.format(dateC.getTime()));
		
		if(dateC.before(sixMonthsAgo)) {
			System.out.println("6 months older than current date!");
		}
		
		
		
		
	}
}
