package thriftbook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import utility.Keywords;

public class Create_An_Account {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.thriftbooks.com/");

			Actions ac = new Actions(driver);
			ac.moveToElement(driver.findElement(By.xpath("//div[@class='UserComponent-login']"))).perform();
			driver.findElement(By.xpath("//a[text()='Create Account']")).click();
			Keywords.wait(2);

			String expectedTitletext = "Create an Account";
			String actualTitletext = driver
					.findElement(By.xpath("//div[@id='divNewUser']//h1[@class='LoginBox-header']")).getText();
			if (!actualTitletext.equals(expectedTitletext)) {
				throw new Exception("Title text doesn't match." + "\nExpected: " + expectedTitletext + "\nActual: "
						+ actualTitletext);
			}
		

			System.out.println("Test Pass (^v^)");
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
