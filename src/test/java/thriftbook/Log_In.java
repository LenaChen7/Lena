package thriftbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import utility.Keywords;

public class Log_In {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String email = "chenlena@outlook.com";
		String password = "798911Miya";

		try {
			driver.get("https://www.thriftbooks.com/");

			Actions ac = new Actions(driver);
			ac.moveToElement(driver.findElement(By.xpath("//div[@class='UserComponent-login']"))).perform();
			driver.findElement(By.xpath("//a[text()='Log In']")).click();
			Keywords.wait(2);

			// Validate to see if Title Text matches
			String expectedTitletext = "Log In";
			String actualTitletext = driver.findElement(By.xpath("//h1[@class='LoginBox-header'][text()='Log In']"))
					.getText();
			if (!actualTitletext.equals(expectedTitletext)) {
				throw new Exception("Title text doesn't match." + "\nExpected: " + expectedTitletext + "\nActual: "
						+ actualTitletext);
			}

			driver.findElement(By.xpath("//input[@id='ExistingAccount_EmailAddress']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@id='ExistingAccount_Password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@type='submit'][@value='Log In']")).click();

			Keywords.wait(2);
			// Validate if you are on the main page
			String expectedUrl = "/account/login/";
			String actuallUrl = driver.getCurrentUrl();
			if (actuallUrl.contains(expectedUrl)) {
				throw new Exception("Url doesn't match." + "\nExpected: " + expectedUrl + "\nActuall: " + actuallUrl);
			}
//			driver.findElement(By.xpath("//input[@id='NewAccount_ConfirmEmail']")).sendKeys(email);
//			Keywords.wait(2);
//			driver.findElement(By.xpath("//input[@id='NewAccount_Password']")).sendKeys(password);
//			driver.findElement(By.xpath("//input[@type='submit'][@value='Create Account']")).click();
//			
//			Keywords.wait(3);
//			
//			// Validate Password
//			if (password.length() < 6) {
//				throw new Exception(
//						"Password length is not matching." + "\nExpected: More than 6" + "\nActull: " + password.length());
//			}
//
//			if(!containsLowercaseOrUppercase(email)) {
//				throw new Exception("Email is invalid" + "\nActuall: " + password);
//			}
//
//			if (password.contains(" ")) {
//				throw new Exception("There is space in it." + "\nActull: " + password);
//			}

			System.out.println("Test Pass (^ v ^)");
		} catch (Exception e) {
			System.out.println("Test Fail");
			e.getStackTrace();
			System.out.println(e.getMessage());

		} finally {
			driver.close();
			driver.quit();
		}

	}

}
