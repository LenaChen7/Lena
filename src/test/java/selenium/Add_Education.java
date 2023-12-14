package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Keywords;

public class Add_Education {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		String username = "chenlena@outlook.com";
		String password = "798911";
		String uRl = "https://boratech-practice-app.onrender.com/login#!";
		// Data
		String school = "Bora Tech" + Keywords.getTimestamp();
		String degree = "Bachlor";
		String fieldOfstudy = "English";
		String description = "lol";
		String from = "12/4/2021";
		String to = "8/7/2023";
		boolean current = false;

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
			Keywords.wait(2);

			// validation
			boolean found = false;
			// table path // table row
			String table = "//h2[text() = 'Education Credentials']/following-sibling::table";
			String tableRowXpath = table + "/tbody/tr";

			List<WebElement> rows = driver.findElements(By.xpath(tableRowXpath));

			for (WebElement row : rows) {

				List<WebElement> cells = row.findElements(By.tagName("td"));

				String actSchool = cells.get(0).getText();
				String actDegree = cells.get(1).getText();

				if (school.equals(actSchool) && degree.equals(actDegree)) {
					found = true;
					break;
				}

			}

			if (!found) {

				throw new Exception("The newly entered education was not found");
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
