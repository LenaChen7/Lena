package selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Keywords;

public class Add_Evaluation_Multi_Errors {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		String username = "chenlena@outlook.com";
		String password = "798911";
		String uRl = "https://boratech-practice-app.onrender.com/login#!";
		// Data
		String school = "";
		String degree = "he";
		String fieldOfstudy = "";
		String description = "lol";
		String from = "12/4/2021";
		String to = "8/7/2023";
		boolean current = false;
		List<String> ExpectedErrorMessages = new ArrayList<>();
		ExpectedErrorMessages.add("School is required");
		ExpectedErrorMessages.add("Degree is required");

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
			
			Keywords.wait(5);
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			Keywords.wait(2);

			// Validation Part
			List<WebElement> errorAlerts = driver.findElements(By.xpath("//div[@class='alert alert-danger']"));
			List<String> ActualErrorAlerts = new ArrayList<>();

			for (WebElement errorAlert : errorAlerts) {
				ActualErrorAlerts.add(errorAlert.getText());
			}

			// compare Error Message 's size
			if (ActualErrorAlerts.size() != ExpectedErrorMessages.size()) {
				String message = "Number of error messages not match\n" + "Expected Error Messages: "
						+ ExpectedErrorMessages + "\nAcually Error Messages: " + ActualErrorAlerts;
				throw new Exception(message);
			}
			// Compare Errors
			for (String ExpectedError : ExpectedErrorMessages) {
				if(!ActualErrorAlerts.contains(ExpectedError)) {
					throw new Exception ("Expected Error not found - [" + ExpectedError + "]");
				}
			}
			System.out.println("Test pass");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed");
			System.out.println("Reason: " + e.getMessage());
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
