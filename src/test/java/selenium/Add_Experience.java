package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class Add_Experience {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		// Login
		String username = "chenlena@outlook.com";
		String password = "798911";
		String uRl = "https://boratech-practice-app.onrender.com/login#!";
		// Data
		String jobTitle = "teacher";
		String company = "RSM";
		String location = "Ashburn";
		String from = "03/10/2023";
		String to = "07/21/2023";
		boolean current = false;
		String description = "teaching math to students";

		try {
			driver.get(uRl);
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password + Keys.ENTER);
			wait(2);

			driver.findElement(By.xpath("//a[@href='/add-experience']")).click();
			wait(2);
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
			wait(2);

			System.out.println("Test Pass");
		} catch (Exception e) {
			System.out.println("Test Failed");
			e.printStackTrace();
			System.out.println("Reason" + e.getMessage());
		} finally {
			driver.close();
			driver.quit();
		}

	}

	public static void wait(int second) throws InterruptedException {

		Thread.sleep(second * 1000);

	}
}
