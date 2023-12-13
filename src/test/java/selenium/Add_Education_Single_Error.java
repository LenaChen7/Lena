package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Keywords;

public class Add_Education_Single_Error {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		String username = "chenlena@outlook.com";
		String password = "798911";
		String uRl = "https://boratech-practice-app.onrender.com/login#!";
		// Data
		String school = "hhhh";
		String degree = "";
		String fieldOfstudy = "English";
		String description = "lol";
		String from = "12/4/2021";
		String to = "8/7/2023";
		boolean current = false;
		String ExpectedErrorMessage = "School is required";

		try {
			// login
			driver.get(uRl);
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password + Keys.ENTER);
			Keywords.wait(2);

			// Add education
			driver.findElement(By.linkText("Add Education")).click();
			Keywords.wait(2);

			driver.findElement(By.xpath("//input[@name='school']")).sendKeys(school);
			driver.findElement(By.xpath("//input[@name='degree']")).sendKeys(degree);
			driver.findElement(By.xpath("//input[@name='fieldofstudy']")).sendKeys(fieldOfstudy);
			driver.findElement(By.xpath("//input[@name = 'from']")).sendKeys(from);

			if (current) {
				driver.findElement(By.xpath("//input[@name = 'current']")).click();
			} else {
				driver.findElement(By.xpath("//input[@name = 'to']")).sendKeys(to);
			}

			driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			Keywords.wait(3);

			List<WebElement> errorAlerts = driver.findElements(By.xpath("//div[@class='alert alert-danger']"));
			if (errorAlerts.size() != 1) {
				throw new Exception("Error message should be only 1");
			}

			String ActuallErrorMessage = errorAlerts.get(0).getText();
			if (!ActuallErrorMessage.equals(ExpectedErrorMessage)) {
				throw new Exception("Error Message Mismatch | " + "Expected: " + ExpectedErrorMessage + " | Actuall: "
						+ ActuallErrorMessage);
			}

			System.out.println("test pass");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test failed");
			System.out.println("Reason: " + e.getMessage());
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
