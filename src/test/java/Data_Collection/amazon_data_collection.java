package Data_Collection;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Keywords;

public class amazon_data_collection {

	public static void main(String[] args) throws IOException {
		// Search for an item
		// Collect the title, price for each result item
		// Write the result into an excel file
		// Calculate the highest price, lowest price and average price
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		List<Amazon_Search_Result_Pojo> results = new ArrayList<>();

		String searchTerm = "shampoo";

		try {

			driver.get("https://www.amazon.com/");
			driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(searchTerm + Keys.ENTER);
			// to check if the element exist
			Keywords.doesElementExist(driver, By.xpath(
					"//span[@data-component-type='s-result-info-bar']" + "//*[contains(text(),'" + searchTerm + "')]"),
					"unable to locate the result page");
			Keywords.wait(3);

			int counter = 0;
			while (counter < 200) {
				String parentXpath = "(//div[@data-component-type='s-search-result'])";
				List<WebElement> cards = wait
						.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(parentXpath), 48));

				for (int i = 1; i <= cards.size(); i++) {
					String titleXpath = parentXpath + "[" + i + "]//h2";
					String priceXpath = parentXpath + "[" + i + "]//span[@class = 'a-price']";
					String priceString = null;
					String title = driver.findElement(By.xpath(titleXpath)).getText();

					try {
						priceString = driver.findElement(By.xpath(priceXpath)).getText();
						priceString = priceString.replace("\n", ".").replace("$", "");
					} catch (NoSuchElementException e) {
						continue;
					}

//					System.out.println(++counter + title + priceString);
//					// use pojo as date collection
					Amazon_Search_Result_Pojo result = new Amazon_Search_Result_Pojo(++counter,
							Double.valueOf(priceString), title);

					results.add(result);

					if (counter == 200) {
						break;
					}

				}
				if (counter == 200) {
					break;
				}

				driver.findElement(By.xpath("//a[contains(@class, 's-pagination-next')]")).click();

			}

			System.out.println("Test Passed");
		} catch (Exception e) {
			System.out.println("Test Failed");
			System.out.println("Reason: " + e.getMessage());
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
		Excel.exportAmazonSearchResults(searchTerm, results);
	}

}
