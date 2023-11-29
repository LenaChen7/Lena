package utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keywords {

	WebDriver driver = new ChromeDriver();

	public static boolean doesElementExist(WebDriver driver, By locator) {

		try {

			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static boolean doesElementExist2(WebDriver driver, By locator) {

		return driver.findElements(locator).size() > 0;

	}

	/**
	 * Coverts date string from "MM/dd/yyyy" to "yyyy-mm-dd" format
	 * 
	 * @param input day string
	 * @return formatted Day string
	 */
	public static String formatInputDate(String expectedDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate date = LocalDate.parse(expectedDate, formatter);
		return date.toString();

	}

}
