package selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Keywords;

public class Add_Experience {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		// Login
		String username = "chenlena@outlook.com";
		String password = "798911";
		String uRl = "https://boratech-practice-app.onrender.com/login#!";
		// Data
		String jobTitle = "teacher";
		String company = "RSM" + Keywords.getTimestamp();
		String location = "Ashburn";
		String from = "03/10/2023";
		String to = "07/21/2023";
		boolean current = false;
		String description = "teaching math to students";

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
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			Keywords.wait(2);

			// table validation
			String tableXpath = "//h2[text()='Experience Credentials']/following-sibling::table[1]";
			String tableRowXpath = tableXpath + "/tbody/tr";

			List<WebElement> rows = driver.findElements(By.xpath(tableRowXpath));

			boolean found = false;

			for (WebElement row : rows) {

				List<WebElement> cells = row.findElements(By.tagName("td"));

				String actCompany = cells.get(0).getText();
				String actJobtitle = cells.get(1).getText();
				if (jobTitle.equals(actJobtitle) && company.equals(actCompany)) {
					found = true;
					break;
				}

			}

			if (!found) {
				throw new Exception("The newly enterd experience was not found");

			}

			System.out.println("Test Pass");

		} catch (Exception e) {
			System.out.println("Test Failed");
			e.printStackTrace();
			System.out.println("Reason： " + e.getMessage());
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
