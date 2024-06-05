package Data_Collection;

import java.time.Duration;
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

public class walmart_data_collection {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String searchTerm = "iphone";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			driver.get("https://www.walmart.com/");
			driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys(searchTerm + Keys.ENTER);
			Keywords.wait(5);
			if (driver.findElement(By.xpath("//h2[@class='f4 f3-m lh-title ma0 di']")).getText().contains(searchTerm)) {
				throw new Exception("We are not on the search result page");
			}

//			String parentXpath = "(//div[@class='h-100 pb1-xl pr4-xl pv1 ph1'])";
//			List<WebElement> cards = wait
//					.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(parentXpath), 30));
//
//			int counter = 1;
//			while (counter < 100) {
//				for (int i = 1; i <= cards.size(); i++) {
//					String titleXpath = parentXpath + "[" + i + "]//span[@data-automation-id='product-title']";
//					String priceXpath = parentXpath + "[" + i + "]//div[@class='b black mr1 lh-copy f5 f4-l']";
//					String title = driver.findElement(By.xpath(titleXpath)).getText();
//					String priceString = null;
//
//					try {
//						priceString = driver.findElement(By.xpath(priceXpath)).getText();
//						priceString = priceString.replace("\n", ".").replace("$", "");
//					} catch (NoSuchElementException e) {
//						continue;
//					}
//
//					if (counter == 100) {
//						break;
//					}
//					System.out.println("ID: " + ++counter + " Price: " + priceString + " Title: " + title);
//
//				}
//
//				if (counter == 100) {
//					break;
//				}
//				driver.findElement(By.xpath("//a[@aria-label='Next Page']")).click();
//
//			}

			System.out.println("test pass");
		} catch (Exception e) {
			System.out.println("test fail");
			System.out.println("Reason: " + e.getMessage());
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
	}

}
