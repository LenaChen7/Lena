package utility;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keywords {

	WebDriver driver = new ChromeDriver();

	public static void doesElementExist(WebDriver driver, By locator, String errorMessage) throws Exception {
		boolean found = doesElementExist(driver, locator);

		if (!found) {
			throw new Exception(errorMessage);
		}

	}

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

		// It creates a date and time formatter for the pattern "MM/dd/yyyy".
		// It parses the string expectedDob (which represents a date) xinto a LocalDate
		// object using the specified formatter.
		// It prints the string representation of the LocalDate object (date) to the
		// console. In this case, it will print "2022-07-29".

	}

	public static void wait(int second) throws InterruptedException {

		Thread.sleep(second * 1000);

	}

	public static String getTimestamp() {
//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime() + "";
	}

	/**
	 * check if the email is valid
	 * 
	 * @param email
	 * @return
	 */
	public static boolean containsLowercaseOrUppercase(String email) {
		// Check for at least one lowercase letter
		boolean hasLowercase = false;
		// Check for at least one uppercase letter
		boolean hasUppercase = false;

		for (char c : email.toCharArray()) {
			if (Character.isLowerCase(c)) {
				hasLowercase = true;
			} else if (Character.isUpperCase(c)) {
				hasUppercase = true;
			}

			// If both conditions are true, no need to continue checking
			if (hasLowercase && hasUppercase) {
				return true;
			}
		}

		// If either condition is true, the email is valid
		return hasLowercase && hasUppercase;
	}

	public static WebDriver driverFactory() {
		WebDriver driver = new ChromeDriver();
		return driver;
	}

//Switch to a new window
	public static void switchToTheNewTab(WebDriver driver) {
		Set<String> handles = driver.getWindowHandles();
		String mainHandle = driver.getWindowHandle();

		for (String handle : handles) {
			if (!handle.equals(mainHandle)) {
				driver.switchTo().window(handle);
			}

		}
	}

}
