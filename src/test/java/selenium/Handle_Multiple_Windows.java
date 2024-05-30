package selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Keywords;

public class Handle_Multiple_Windows {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		// implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		// Maximize Window
		driver.manage().window().maximize();

		try {

			driver.get("https://www.google.com/m?client=ms-android-samsung-rvo1&source=android-home");
			driver.findElement(By.name("q")).sendKeys("BoraTech" + Keys.ENTER);
			// get the window handle for the current window
			String mainHandle = driver.getWindowHandle();
			System.out.println("Main Handle: " + mainHandle);

			// Open a new tab , sitches selenium to focus on the new tab
			// Open : commend T , close : commend W
			// Selenium only focus on & perform actions on 1 window at a time
			driver.switchTo().newWindow(WindowType.TAB);
			driver.navigate().to("https://www.walmart.com/");
			driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys("Shampoo" + Keys.ENTER);

			String newHandle = driver.getWindowHandle();
			System.out.println("New Handle: " + newHandle);

			Set<String> handles = driver.getWindowHandles();
			System.out.println("All Handles: " + handles);

			// To switch between windows
			driver.switchTo().window(mainHandle);
			driver.close();
			Keywords.wait(3);
			// Selenium doesn't automatically switch to other windows
			driver.switchTo().window(newHandle);
			driver.close();
			Keywords.wait(3);

			System.out.println("Test Pass");

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			// close the current window

		}
	}

}
