package barnes_noble;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Keywords;

public class Audiobook {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String url = "https://www.barnesandnoble.com/";

		try {

			driver.navigate().to(url);
			driver.findElement(By.id("rhfCategoryFlyout_Audiobooks")).click();
			Keywords.wait(2);
			driver.navigate().back();
			Keywords.wait(2);
			driver.findElement(By.xpath("//h1[text()='Audiobooks']"));
			System.out.println("Test Pass");

		} catch (Exception NoSuchElementException) {
			System.out.println("Test Fail");
			System.out.println("You are not on the audiobook page. " + driver.getCurrentUrl());
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
