package Data_Collection;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Keywords;

public class amazon_data_collection {

	public static void main(String[] args) {
		// Search for an item
		// Collect the title, price for each result item
		// Write the result into an excel file
		// Calculate the highest price, lowest price and average price
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		String searchTerm = "shampoo";

		try {
			driver.get("https://www.amazon.com/");
			driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(searchTerm + Keys.ENTER);
			Keywords.doesElementExist(driver, By.xpath(
					"//span[@data-component-type='s-result-info-bar']" + "//*[contains(text(),'" + searchTerm + "')]"),
					"unable to locate the result page");
			Keywords.wait(3);
//			wait.until(ExpectedConditions.visibilityOf(null))

			System.out.println("Test Passed");
		} catch (Exception e) {
			System.out.println("Test Failed");
			System.out.println("Reason: " + e.getMessage());
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
	}

}
