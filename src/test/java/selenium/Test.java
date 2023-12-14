package selenium;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Keywords;

public class Test {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://www.barnesandnoble.com/b/books/_/N-29Z8q8");

			Keywords.wait(2);

			driver.navigate().back();
			
			Keywords.wait(2);

		} catch (Exception e) {
			System.out.println("Test Fail");
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			driver.close();
			driver.quit();
		}
	}

}
