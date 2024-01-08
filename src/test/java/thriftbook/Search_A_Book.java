package thriftbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Keywords;

public class Search_A_Book {

	public static void main(String[] args) {
		
		String book = "little women";
		search_For_item(book);

	}

	public static void search_For_item(String book) {
		WebDriver localDriver = Keywords.driverFactory();
		try {
			localDriver.get("https://www.thriftbooks.com/");
			Keywords.wait(4);
			localDriver.findElement(By.xpath("//input[@class='Search-input is-empty']")).sendKeys(book);
			Keywords.wait(3);
			localDriver.findElement(By.xpath("//div[@class='Search-submit Button-container is-flat']")).click();
			Keywords.wait(3);

			String actualTitletext = localDriver.findElement(By.xpath("//div[@class='Search-sortBar-results']")).getText();

			if (!actualTitletext.contains(book)) {
				throw new Exception(
						"Title Text doesn't match." + "\nExpected Contain: " + book + "\nActual: " + actualTitletext);
			}

			System.out.println("Test Pass");

		} catch (Exception e) {
			System.out.println("Test Fail");
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			localDriver.close();
			localDriver.quit();
		}

	}

}
