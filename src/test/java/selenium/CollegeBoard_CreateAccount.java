package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CollegeBoard_CreateAccount {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://cbaccount.collegeboard.org/iamweb/smartRegister?appId=292&DURL=https%3A%2F%2Fwww.collegeboard.org%2F");
		try {
			driver.findElement(By.id("firstNameField")).sendKeys("Lena");
			Thread.sleep(2000);
			System.out.println("test pass");
		} catch (Exception e) {
			System.out.println("test fail" + e.getStackTrace());
		} finally {
			driver.close();
			driver.quit();
		}
	}

}
