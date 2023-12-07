package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Add_Education {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		String uRl = "https://boratech-practice-app.onrender.com/";
		// Loging Credential
		String username = "chenlena@outlook.com";
		String password = "798911";
		// Data
		String school = "Bora Tech";
		String degree = "Bachlor";
		String fieldOfstudy = "English";
		String description = "lol";

		try {

			// login
			driver.navigate().to(uRl);
			driver.findElement(By.linkText("Login")).click();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password + Keys.ENTER);

			wait(2);
			// Add education
			driver.findElement(By.linkText("Add Education")).click();

			driver.findElement(By.xpath("//input[@name='school']")).sendKeys(school);
			driver.findElement(By.xpath("//input[@name='degree']")).sendKeys(degree);
			driver.findElement(By.xpath("//input[@name='fieldofstudy']")).sendKeys(fieldOfstudy);
			driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);

			wait(2);

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

	public static void wait(int second) throws InterruptedException {

		Thread.sleep(second * 1000);

	}

}
