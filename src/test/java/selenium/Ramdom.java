package selenium;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ramdom {

	public static void main(String[] args) {
		String expectedDob = "07/29/2022";
		// It initializes a string variable expectedDob with the value "07/29/2022".

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		// It creates a date and time formatter for the pattern "MM/dd/yyyy".

		LocalDate date = LocalDate.parse(expectedDob, formatter);
		// It parses the string expectedDob (which represents a date)
		// into a LocalDate object using the specified formatter.

		System.out.println(date.toString());
		// It prints the string representation of the LocalDate object (date) to the console.
		// in this case, it will print "2022-07-29".

	}

}
