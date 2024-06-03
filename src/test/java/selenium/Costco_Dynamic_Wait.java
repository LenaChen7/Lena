package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Keywords;

public class Costco_Dynamic_Wait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		try {
			driver.get("https://www.costco.com/");

			WebElement audioDealsCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//img[@alt='Apple Watch Series 9. A Gift from the heart. $90 OFF'][2]")));

			audioDealsCard.click();
			Keywords.doesElementExist(driver,
					By.xpath("//h1[@automation-id='headerOutput'][contains(text(), 'Series 9 Apple Watch')]"),
					"Failed to navigate to the apple watch page");
			System.out.println("test passed");
		} catch (Exception e) {
			System.out.println("test failed");
			System.out.println("Reason: " + e.getMessage());
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
