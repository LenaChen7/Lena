package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String url = "https://www.nike.com/";
		String WebPageEnd = "2phlm";

		try {

			driver.get(url);
			driver.findElement(By.xpath("//a[@data-analytics-action-id='469fbba7-cf95-4c54-8523-02499d61945a']"))
					.click();

			Thread.sleep(2000);

			if (driver.getCurrentUrl().endsWith(WebPageEnd)) {
				System.out.println("test passed");
			} else {
				System.out.println("test failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
	}

}
