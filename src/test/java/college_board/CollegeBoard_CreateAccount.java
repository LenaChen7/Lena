package college_board;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CollegeBoard_CreateAccount {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.collegeboard.org/");
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
