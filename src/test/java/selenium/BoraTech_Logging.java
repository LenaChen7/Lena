package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoraTech_Logging {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		try {
			driver.navigate().to("https://boratech-practice-app.onrender.com/");
			List<WebElement> logins = driver.findElements(By.linkText("Login"));
			for (WebElement webElement : logins) {
				System.out.println(webElement.getText());
			}
			System.out.println("TEST PASS");
		} catch (Exception e) {
			System.out.println("Test Failed" + e.getMessage());
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
