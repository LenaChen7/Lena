package selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Keywords;

public class Add_Experience_Multi_Error {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		// Login
		String username = "chenlena@outlook.com";
		String password = "798911";
		String uRl = "https://boratech-practice-app.onrender.com/login#!";
		// Data
		String jobTitle = "";
		String company = "";
		String location = "fff";
		String from = "03/10/2023";
		String to = "07/21/2023";
		boolean current = false;
		String description = "teaching math to students";
		List<String> expectedErrors = new ArrayList<>();
		expectedErrors.add("Title is required");
		expectedErrors.add("Company is required");

		try {
			driver.get(uRl);
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password + Keys.ENTER);
			Keywords.wait(2);

			driver.findElement(By.xpath("//a[@href='/add-experience']")).click();
			Keywords.wait(2);
			driver.findElement(By.xpath("//input[@name='title']")).sendKeys(jobTitle);
			driver.findElement(By.xpath("//input[@name='company']")).sendKeys(company);
			driver.findElement(By.xpath("//input[@name='location']")).sendKeys(location);
			driver.findElement(By.xpath("//input[@name='from']")).sendKeys(from);
			if (current) {
				driver.findElement(By.xpath("//input[@name='current']")).click();
			} else {
				driver.findElement(By.xpath("//input[@name='to']")).sendKeys(to);
			}
			driver.findElement(By.tagName("textarea")).sendKeys(description);
			Keywords.wait(5);
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			// validation
			Keywords.wait(2);
			List<WebElement> ErrorMessages = driver.findElements(By.xpath("//div[@class='alert alert-danger']"));
			List<String> actualErrors = new ArrayList<>();
			for (WebElement errorMessage : ErrorMessages) {
				actualErrors.add(errorMessage.getText());
			}

			// Compare size
			if (actualErrors.size() != expectedErrors.size()) {
				throw new Exception(
						"Number of Errors not match.\nExpected: " + expectedErrors + "\nActuall: " + actualErrors);
			}
			// Compare Errors
			for (String expectedError : expectedErrors) {
				if (!actualErrors.contains(expectedError)) {
					String message = "Error message not matched." + "\nExpected Error: " + expectedErrors
							+ "\nActuall Error: " + actualErrors;
					throw new Exception(message);
				}
			}

			System.out.println("Test Pass");

		} catch (Exception e) {
			System.out.println("Test Failed");
			System.out.println("Reason： " + e.getMessage());
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
