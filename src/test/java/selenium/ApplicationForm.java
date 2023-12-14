package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Keywords;

public class ApplicationForm {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String url = "https://boratech-practice-app.onrender.com/";
		String firstName = "Lena";
		String lastName = "Chen";
		String dob = "07/01/1995";
		String email = "chenlena@outlook.com";
		String phone = "";

		try {
			driver.get(url);
			driver.findElement(By.linkText("Apply Now")).click();
			Keywords.wait(2);

			// 1. Validate URL has /apply at the end
			String actualUrl = driver.getCurrentUrl();
			if (!actualUrl.endsWith("/apply")) {
				throw new Exception("Expected to have '/apply' in the url." + "\nCurrent: " + actualUrl);
			}

			Keywords.wait(2);

			// 2. Validate Title Text
			String expectedTitleText = "Application Form";
			String actualTitleText = driver.findElement(By.xpath("//h1[@class='large text-primary']")).getText();
			if (!actualTitleText.equals(expectedTitleText)) {
				throw new Exception("Title Text doesn't match.\n" + "Expected: " + expectedTitleText + "\nActual: "
						+ actualTitleText);
			}

			System.out.println("Test Passed");
		} catch (Exception e) {
			System.out.println("Test Failed");
			System.out.println(e.getMessage());
			e.getStackTrace();

		} finally {
			driver.close();
			driver.quit();
		}
	}

}
