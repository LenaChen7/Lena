package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoraTech_Logging {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String expectedText = "Dashboard";
		String email = "chenlena@outlook.com";
		String password = "798911";
		String expectedURL = "/dashboard";

		try {
			driver.navigate().to("https://boratech-practice-app.onrender.com/");
			driver.findElement(By.linkText("Login")).click();

//			String actuallText = driver.findElement(By.xpath("//p[@class = 'lead']")).getText();
			// cssSelector("p.lead")

			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@type='submit']")).click();

			Thread.sleep(2000);

			// Validation

			String actuallText = driver.findElement(By.xpath("//h1[@class='large text-primary']")).getText();
			if (!(expectedText.equals(actuallText))) {
				throw new Exception("\tTitle Text doesn't match , expected: " + expectedText + "\tActuall Title Text: "
						+ actuallText);

			}

			String currentURL = driver.getCurrentUrl();
			if (!(currentURL.endsWith(expectedURL))) {
				throw new Exception("\t expected URL: " + expectedURL + "Actuall URL: " + currentURL);

			}

			driver.findElement(By.xpath("//a[@href='#!']/span[text() = 'Logout']"));

			System.out.println("Text Passed");

		} catch (Exception e) {

			System.out.println("Test Failed");
			System.out.println("Reason: " + e.getMessage());
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
