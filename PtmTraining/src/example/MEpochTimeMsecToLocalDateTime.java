package example;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class MEpochTimeMsecToLocalDateTime {
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD/MM/YYYY hh:mm:ss");
	public static void main(String[] args) {
		//Epoch time is the number of seconds that have elapsed since 0:00:00 UTC on 1 January 1970
		//Syntax
		//--------------------
		//LocalDate ld = Instant.ofEpochMilli(epoch).atZone(ZoneId.systemDefault()).toLocalDate();
		long epoch = Instant.now().toEpochMilli();
		System.out.println(epoch);
		LocalDate ld = Instant.ofEpochMilli(epoch)
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
		System.out.println(ld);
		LocalDateTime ldt = Instant.ofEpochMilli(epoch)
				.atZone(ZoneId.systemDefault())
				.toLocalDateTime();
		System.out.println(dtf.format(ldt));
	}
}
